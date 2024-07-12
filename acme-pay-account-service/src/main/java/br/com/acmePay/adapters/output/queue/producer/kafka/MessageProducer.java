package br.com.acmePay.adapters.output.queue.producer.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageProducer implements ISendMessage {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void execute(String topic, Object message) {
        kafkaTemplate.send(topic, message);
    }


}
