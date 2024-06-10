package br.com.acmePay.adapters.output.queue.service;

import br.com.acmePay.adapters.output.queue.ProducerMessage;
import br.com.acmePay.adapters.request.DocumentRequest;
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
    public void execute(DocumentRequest request) {
        producerMessage.publish(request);
        log.info("Publish successfully to payload {}" , request);
    }
}