package br.com.acmePay.adapters.input.queue.service;

import br.com.acmePay.adapters.input.queue.IConsumerMessage;
import br.com.acmePay.adapters.input.queue.dto.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageConsumer implements IConsumerMessage {

    private final ObjectMapper objectMapper;

    @Override
    public void execute(String message) throws JsonProcessingException {

        System.out.println("Received message: " + message);

        Transaction transferMessage = objectMapper.readValue(message, Transaction.class);

        System.out.println(transferMessage.toString());
    }
}

