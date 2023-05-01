package ru.michaelshell.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.michaelshell.fraud.entity.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
