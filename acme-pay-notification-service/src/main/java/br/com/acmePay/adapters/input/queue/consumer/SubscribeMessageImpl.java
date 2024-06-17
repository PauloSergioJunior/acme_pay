package br.com.acmePay.adapters.input.queue.consumer;

import br.com.acmePay.application.ports.in.IFindStatusByDocUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SubscribeMessageImpl implements ConsumerMessage {

    private IFindStatusByDocUseCase useCase;

    @RabbitListener(queues = "queue_check_document")
    @Override
    public void subscribe(String document) {

        useCase.execute(document);

        log.info("Subscribe : Payload {} / Queue {}", document, "queue_check_document");
    }

}
