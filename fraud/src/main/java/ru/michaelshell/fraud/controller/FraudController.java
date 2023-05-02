package ru.michaelshell.fraud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.michaelshell.clients.fraud.dto.FraudCheckResponse;
import ru.michaelshell.fraud.service.FraudCheckHistoryService;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        log.info("request to fraud from customer {}", customerId);
        return new FraudCheckResponse(fraudCheckHistoryService.isFraudulentCustomer(customerId));
    }
}
