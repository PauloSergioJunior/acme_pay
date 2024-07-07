package br.com.acmePay.adapters.output.queue;


import br.com.acmePay.constants.ConstantsRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishMessageImpl implements ProducerMessage{

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(String documentRequest) {
        log.info("Publishing : Payload {} / Queue {}", documentRequest, ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT);
        this.rabbitTemplate.convertSendAndReceive(ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT, documentRequest);
        log.info("Published : Payload {} / Queue {}", documentRequest, ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT);

    }

}