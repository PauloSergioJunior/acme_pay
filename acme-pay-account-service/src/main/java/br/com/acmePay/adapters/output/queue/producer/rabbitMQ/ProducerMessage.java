package br.com.acmePay.adapters.output.queue.producer.rabbitMQ;

public interface ProducerMessage {
    void publish(String document);
}
