package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.AccountEntity;
import br.com.acmePay.adapters.output.database.repository.IAccountRedisRepository;
import br.com.acmePay.adapters.output.database.repository.IAccountRepository;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.out.ICreateAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CreateAccountService implements ICreateAccount {

    private final IAccountRepository repository;
    private final IAccountRedisRepository redisRepository;

    @Override
    public void createDomain(AccountDomain accountDomain) {

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

    @Override
    public void execute(String document) {

        var entityRedis = redisRepository.findById(document);

        if (entityRedis.isPresent()) {

            var entity = AccountEntity.builder()
                    .agency(entityRedis.get().getAgency())
                    .balance(entityRedis.get().getBalance())
                    .close(entityRedis.get().getClose())
                    .number(entityRedis.get().getNumber())
                    .document(entityRedis.get().getDocument())
                    .created_at(LocalDateTime.now())
                    .updated_at(null)
                    .build();

            repository.save(entity);

            redisRepository.delete(entityRedis.get());

        }

    }
}
