package br.com.acmePay.adapters.output.queue;

public interface ProducerMessage {
    void publish(String document);
}
