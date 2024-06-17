package br.com.acmePay;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class NotificationService {
    public static void main(String[] args) {

        SpringApplication.run(NotificationService.class, args);
    }
}
