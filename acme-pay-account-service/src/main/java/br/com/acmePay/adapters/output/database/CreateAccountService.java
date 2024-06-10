package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.AccountEntity;
import br.com.acmePay.adapters.output.database.repository.IAccountRepository;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.out.ICreateAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateAccountService implements ICreateAccount {

    private final IAccountRepository repository;

    @Override
    public void execute(AccountDomain accountDomain) {
        var entity = AccountEntity.builder()
                .agency(accountDomain.getAgency())
                .number(accountDomain.getNumber())
                .balance(accountDomain.getBalance())
                .document(accountDomain.getDocument())
                .created_at(accountDomain.getCreated_at())
                .updated_at(accountDomain.getUpdated_at())
                .close(accountDomain.getClose())
                .build();

        repository.save(entity);
    }
}
