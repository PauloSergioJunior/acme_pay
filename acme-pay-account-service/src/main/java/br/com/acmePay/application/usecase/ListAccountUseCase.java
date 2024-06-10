package br.com.acmePay.application.usecase;

import br.com.acmePay.application.ports.in.IListAccountUseCase;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.out.IListAccount;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class ListAccountUseCase implements IListAccountUseCase {

    private final IListAccount listAccount;

    
    @Override
    public List<AccountDomain> execute() {

        var accountDomain = AccountDomain.builder().build();

     return accountDomain.listAccount(listAccount);
    }
    
}
