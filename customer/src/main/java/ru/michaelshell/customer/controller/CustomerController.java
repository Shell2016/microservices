package ru.michaelshell.customer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.michaelshell.customer.dto.CustomerRegisterRequest;
import ru.michaelshell.customer.entity.Customer;
import ru.michaelshell.customer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    private Customer registerCustomer(@RequestBody CustomerRegisterRequest request) {

        return customerService.createCustomer(request);
    }
}
