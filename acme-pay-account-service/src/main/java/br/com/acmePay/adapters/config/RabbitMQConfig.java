package br.com.acmePay.adapters.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Filas
    @Bean
    public Queue queueCheckDocument() {
        return QueueBuilder.durable("queue_check_document").build();
    }

    @Bean
    public Queue queueSuccessDocument() {
        return QueueBuilder.durable("queue_success_document").build();
    }

    @Bean
    public Queue queueFailDocument() {
        return QueueBuilder.durable("queue_fail_document").build();
    }

    // Exchanges
    @Bean
    public DirectExchange exchangeCheckDocument() {
        return new DirectExchange("check_document_queue_exchange");
    }

    @Bean
    public DirectExchange exchangeSuccessDocument() {
        return new DirectExchange("check_document_queue_exchange_success");
    }

    @Bean
    public DirectExchange exchangeFailDocument() {
        return new DirectExchange("check_document_queue_exchange_fail");
    }

    // Bindings
    @Bean
    public Binding bindingCheckDocument() {
        return BindingBuilder
                .bind(queueCheckDocument())
                .to(exchangeCheckDocument())
                .with("check_document");
    }

    @Bean
    public Binding bindingSuccessDocument() {
        return BindingBuilder
                .bind(queueSuccessDocument())
                .to(exchangeSuccessDocument())
                .with("success_document");
    }

    @Bean
    public Binding bindingFailDocument() {
        return BindingBuilder
                .bind(queueFailDocument())
                .to(exchangeFailDocument())
                .with("fail_document");
    }
}
