package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.ValidDocumentException;
import br.com.acmePay.application.ports.in.ICreateAccountUseCase;
import br.com.acmePay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmePay.application.ports.out.ICreateRedisAccount;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final ICheckDocumentCustomer checkDocumentCustomer;
    private final ICreateRedisAccount iCreateTemporaryAccount;

    @Override
    public void execute(AccountDomain domain) throws ValidDocumentException {
        domain.create(iCreateTemporaryAccount, checkDocumentCustomer);
    }

}
