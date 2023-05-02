package ru.michaelshell.notification.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.michaelshell.clients.notification.dto.NotificationRequest;
import ru.michaelshell.notification.service.NotificationService;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void notification(@RequestBody NotificationRequest request) {
        notificationService.send(request);
        log.info("notification for user {}", request.userId());
    }
}
