package br.com.acmePay.adapters.output.queue.service;

import br.com.acmePay.adapters.output.queue.IProducerMessage;
import br.com.acmePay.application.domain.enums.StatusDocument;
import br.com.acmePay.constants.ConstantsRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProducerMessageService implements IProducerMessage {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(String status) {

        if (status.equals(StatusDocument.ACTIVE)){
            log.info("publish : Payload {} / Queue {}", status, ConstantsRabbitMQ.QUEUE_SUCCESS_DOCUMENT);
            rabbitTemplate.convertAndSend(ConstantsRabbitMQ.QUEUE_SUCCESS_DOCUMENT, status);
        }else {
            log.info("publish : Payload {} / Queue {}", status, ConstantsRabbitMQ.QUEUE_FAIL_DOCUMENT);
            rabbitTemplate.convertAndSend(ConstantsRabbitMQ.QUEUE_FAIL_DOCUMENT, status);
        }

    }
}
