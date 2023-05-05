package ru.michaelshell.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import ru.michaelshell.amqp.RabbitMQMessageProducer;

@SpringBootApplication(scanBasePackages = {
        "ru.michaelshell.amqp",
        "ru.michaelshell.notification"
})
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }



//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
//                                        TopicExchange internalExchange,
//                                        Binding binding) {
//        return args -> {
//            producer.publish("foo", internalExchange.getName(), binding.getRoutingKey());
//        };
//    }
}
