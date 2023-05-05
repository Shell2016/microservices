package ru.michaelshell.notification.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

//@ConfigurationProperties("rabbit")
public record RabbitMQProperties(Map<String, String> exchanges,
                                 Map<String, String> queues,
                                 Map<String, String> routingKeys) {
}
