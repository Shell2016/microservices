package ru.michaelshell.fraud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.michaelshell.clients.fraud.FraudCheckResponse;
import ru.michaelshell.fraud.service.FraudCheckHistoryService;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        return new FraudCheckResponse(fraudCheckHistoryService.isFraudulentCustomer(customerId));
    }
}
