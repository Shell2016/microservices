package ru.michaelshell.customer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.michaelshell.clients.notification.NotificationClient;
import ru.michaelshell.clients.fraud.dto.FraudCheckResponse;
import ru.michaelshell.clients.fraud.FraudClient;
import ru.michaelshell.clients.notification.dto.NotificationRequest;
import ru.michaelshell.customer.dto.CustomerRegisterRequest;
import ru.michaelshell.customer.entity.Customer;
import ru.michaelshell.customer.repository.CustomerRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    //    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public Customer createCustomer(CustomerRegisterRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
//        FraudCheckResponse response = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class, customer.getId());
        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());
        log.info("Sent request to fraud with customerId {}", customer.getId());

        assert response != null;
        if (response.isFraudster()) {
            throw new IllegalStateException("Customer is fraudster!");
        }

        NotificationRequest notificationRequest = new NotificationRequest(customer.getEmail(),
                "Welcome, " + customer.getFirstName(),
                customer.getId()
        );
        notificationClient.notification(notificationRequest);
        log.info("Sent request to notification service with {}", notificationRequest);
        return customer;
    }
}
