package ru.michaelshell.notification.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.michaelshell.clients.notification.dto.NotificationRequest;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbit.queues.notification}")
    public void consume(NotificationRequest notificationRequest) {
        notificationService.send(notificationRequest);
        log.info("Consumed message from rabbitMQ: {}", notificationRequest);
    }

}
