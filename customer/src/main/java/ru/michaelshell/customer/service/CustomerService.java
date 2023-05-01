package ru.michaelshell.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.michaelshell.customer.dto.CustomerRegisterRequest;
import ru.michaelshell.customer.dto.FraudCheckResponse;
import ru.michaelshell.customer.entity.Customer;
import ru.michaelshell.customer.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public Customer createCustomer(CustomerRegisterRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId());
        assert response != null;
        if (response.isFraudster()) {
            throw new IllegalStateException("Customer is fraudster!");
        }
        return customer;
    }
}
