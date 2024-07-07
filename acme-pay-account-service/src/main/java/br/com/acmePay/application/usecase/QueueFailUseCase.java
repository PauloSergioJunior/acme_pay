package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.in.IQueueFailUseCase;
import br.com.acmePay.application.ports.out.IDeleteRedisAccount;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class QueueFailUseCase implements IQueueFailUseCase {

    private final IDeleteRedisAccount deleteRedisAccount;

    @Override
    public void execute(String document) {

        var accountDomain = AccountDomain.builder().build();

        accountDomain.invalidDocument(deleteRedisAccount, document);

    }
}
