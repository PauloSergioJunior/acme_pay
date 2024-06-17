package br.com.acmePay.adapters.output.queue;

public interface IProducerMessage {
    void publish(String status);
}
