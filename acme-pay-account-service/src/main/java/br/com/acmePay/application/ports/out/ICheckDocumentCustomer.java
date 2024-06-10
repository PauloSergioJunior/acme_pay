package br.com.acmePay.application.ports.out;

import br.com.acmePay.adapters.request.DocumentRequest;

public interface ICheckDocumentCustomer {
    void execute(DocumentRequest request);
}
