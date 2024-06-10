package br.com.acmePay.adapters.output.queue;

import br.com.acmePay.adapters.request.DocumentRequest;

public interface ProducerMessage {
    void publish(DocumentRequest documentRequest);
}
