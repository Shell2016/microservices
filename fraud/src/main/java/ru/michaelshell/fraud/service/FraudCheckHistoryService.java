package ru.michaelshell.fraud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.michaelshell.fraud.entity.FraudCheckHistory;
import ru.michaelshell.fraud.repository.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.save(FraudCheckHistory.builder()
                .isFraudster(false)
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build());

        return false;
    }
}
