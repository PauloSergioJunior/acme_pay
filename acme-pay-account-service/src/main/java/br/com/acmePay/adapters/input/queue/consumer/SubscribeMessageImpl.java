package br.com.acmePay.adapters.input.queue.consumer;

import br.com.acmePay.adapters.input.queue.ConsumerMessage;
import br.com.acmePay.application.ports.in.IQueueFailUseCase;
import br.com.acmePay.application.ports.in.IQueueSuccessUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SubscribeMessageImpl implements ConsumerMessage {

    private final IQueueSuccessUseCase successUseCase;
    private final IQueueFailUseCase failUseCase;

    @RabbitListener(queues = "queue_success_document")
    @Override
    public void subscribe(String document) {

        successUseCase.execute(document);

        log.info("Subscribe : Payload {} / Queue {}", document, "queue_success_document");
    }

    @RabbitListener(queues = "queue_fail_document")
    @Override
    public void subscribeInvalid(String document) {

        failUseCase.execute(document);

        log.info("Subscribe : Payload {} / Queue {}", document, "queue_fail_document");

    }


}
