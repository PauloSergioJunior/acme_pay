package br.com.acmePay.adapters.output.queue.producer.kafka;

public interface ISendMessage {
    void execute(String topic, Object message);
}
