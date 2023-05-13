package ru.michaelshell.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {
        "ru.michaelshell.amqp",
        "ru.michaelshell.notification"
})
@PropertySource("classpath:clients-${spring.profiles.active}.properties")
@EnableEurekaClient
//@EnableConfigurationProperties(RabbitMQProperties.class)
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
