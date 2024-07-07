package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.AccountRedisEntity;
import br.com.acmePay.adapters.output.database.repository.IAccountRedisRepository;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.out.ICreateRedisAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateRedisAccountService implements ICreateRedisAccount {

    private final IAccountRedisRepository repository;

    @Override
    public void execute(AccountDomain domain) {


        var entity = AccountRedisEntity.builder()
                .agency(domain.getAgency())
                .number(domain.getNumber())
                .balance(domain.getBalance())
                .document(domain.getDocument())
                .close(domain.getClose())
                .build();

       repository.save(entity);


    }
}
