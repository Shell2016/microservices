package ru.michaelshell.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.michaelshell.clients.notification.dto.NotificationRequest;

@FeignClient(
        name = "notification",
        url = "${clients.notification.url}"
)
public interface NotificationClient {

    @PostMapping("/api/v1/notification")
    void notification(NotificationRequest request);
}
