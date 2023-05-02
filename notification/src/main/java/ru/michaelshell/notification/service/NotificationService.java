package ru.michaelshell.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.michaelshell.clients.notification.dto.NotificationRequest;
import ru.michaelshell.notification.entity.Notification;
import ru.michaelshell.notification.repository.NotificationRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Transactional
    public void send(NotificationRequest request) {
        notificationRepository.save(Notification.builder()
                        .email(request.email())
                        .message(request.message())
                        .userId(request.userId())
                        .sentAt(LocalDateTime.now())
                .build());
    }
}
