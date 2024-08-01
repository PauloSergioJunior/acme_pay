package br.com.acmePay.adapters.input.queue;

import br.com.acmePay.constants.ConstantsKafka;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

public interface IConsumerMessage {

    @KafkaListener(topics = ConstantsKafka.TOPIC_TRANSFER_NAME, groupId = ConstantsKafka.GROUP_ID)
    void execute(@Payload String message) throws JsonProcessingException;
}
