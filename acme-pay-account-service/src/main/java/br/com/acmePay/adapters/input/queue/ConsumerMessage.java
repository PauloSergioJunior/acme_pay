package br.com.acmePay.adapters.input.queue;


public interface ConsumerMessage {

    void subscribe(String document);
    void subscribeInvalid(String document);
}
