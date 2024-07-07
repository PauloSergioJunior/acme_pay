package br.com.acmePay.adapters.output.queue.service;

import br.com.acmePay.adapters.output.queue.ProducerMessage;
import br.com.acmePay.application.ports.out.ICheckDocumentCustomer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CheckDocumentCustomerService implements ICheckDocumentCustomer {

    private final ProducerMessage producerMessage;

    @Override
    public void execute(String document) {
        producerMessage.publish(document);
        log.info("Publish successfully to payload {}" , document);
    }
}