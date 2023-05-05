package ru.michaelshell.amqp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payLoad, String exchange, String routingKey) {
        log.info("Publishing object {} to exchange {}, using routingKey {}", payLoad, exchange, routingKey);
        amqpTemplate.convertAndSend(exchange, routingKey, payLoad);
        log.info("Published object {} to exchange {}, using routingKey {}", payLoad, exchange, routingKey);
    }
}
