package ru.michaelshell.customer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.michaelshell.customer.dto.CustomerRegisterRequest;
import ru.michaelshell.customer.entity.Customer;
import ru.michaelshell.customer.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(CustomerRegisterRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        return customerRepository.save(customer);
    }
}
