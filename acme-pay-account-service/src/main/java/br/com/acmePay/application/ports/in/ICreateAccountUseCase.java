package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.ValidDocumentException;

public interface ICreateAccountUseCase {
    void execute(AccountDomain domain) throws ValidDocumentException;
}
