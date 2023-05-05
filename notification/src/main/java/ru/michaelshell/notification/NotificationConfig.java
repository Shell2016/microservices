package ru.michaelshell.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

//    @Value("${rabbitmq.exchanges.internal}")
//    private final String internalExchange;
//
//    @Value("${rabbitmq.queue.notification}")
//    private final String notificationQueue;
//
//    @Value("${rabbitmq.routing-keys.internal-notification}")
//    private final String internalNotificationRoutingKey;


    @Bean
    public TopicExchange internalExchange(@Value("${rabbitmq.exchanges.internal}")
                                               String internalExchange) {
        return new TopicExchange(internalExchange);
    }

    @Bean
    public Queue notificationQueue(@Value("${rabbitmq.queue.notification}")
                                   String notificationQueue) {
        return new Queue(notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding(@Value("${rabbitmq.routing-keys.internal-notification}")
                                                 String internalNotificationRoutingKey,
                                                 Queue notificationQueue,
                                                 TopicExchange internalExchange) {
        return BindingBuilder
                .bind(notificationQueue)
                .to(internalExchange)
                .with(internalNotificationRoutingKey);
    }


}
