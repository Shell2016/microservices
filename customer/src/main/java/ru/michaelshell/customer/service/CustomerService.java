package ru.michaelshell.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.michaelshell.clients.notification.NotificationClient;
import ru.michaelshell.clients.fraud.dto.FraudCheckResponse;
import ru.michaelshell.clients.fraud.FraudClient;
import ru.michaelshell.clients.notification.dto.NotificationRequest;
import ru.michaelshell.customer.dto.CustomerRegisterRequest;
import ru.michaelshell.customer.entity.Customer;
import ru.michaelshell.customer.repository.CustomerRepository;

@Service
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

        assert response != null;
        if (response.isFraudster()) {
            throw new IllegalStateException("Customer is fraudster!");
        }

        notificationClient.notification(new NotificationRequest(customer.getEmail(),
                "Welcome, " + customer.getFirstName(),
                customer.getId()
                ));

        return customer;
    }
}
