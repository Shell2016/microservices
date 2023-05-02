package ru.michaelshell.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.michaelshell.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
