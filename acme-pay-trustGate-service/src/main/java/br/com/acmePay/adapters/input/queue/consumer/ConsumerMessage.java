package br.com.acmePay.adapters.input.queue.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface ConsumerMessage {

    void subscribe(String document);
}
