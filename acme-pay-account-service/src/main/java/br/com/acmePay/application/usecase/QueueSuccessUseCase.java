package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.in.IQueueSuccessUseCase;
import br.com.acmePay.application.ports.out.ICreateAccount;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class QueueSuccessUseCase implements IQueueSuccessUseCase {

    private final ICreateAccount createAccount;

    @Override
    public void execute(String document) {

        var accountDomain  = AccountDomain.builder().build();

        accountDomain.validDocument(createAccount, document);

    }
}
