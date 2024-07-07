package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.AccountRedisEntity;
import br.com.acmePay.adapters.output.database.repository.IAccountRedisRepository;
import br.com.acmePay.application.ports.out.IDeleteRedisAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteRedisAccountService implements IDeleteRedisAccount {

    private final IAccountRedisRepository redisRepository;

    @Override
    public void execute(String document) {

        var redisEntity = redisRepository.findById(document);

        redisEntity.ifPresent(redisRepository::delete);


    }
}
