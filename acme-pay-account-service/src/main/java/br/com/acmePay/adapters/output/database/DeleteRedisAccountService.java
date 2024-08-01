package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.AccountRedisEntity;
import br.com.acmePay.adapters.output.database.repository.IAccountRedisRepository;
import br.com.acmePay.application.ports.out.IDeleteRedisAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteRedisAccountService implements IDeleteRedisAccount {

    private final IAccountRedisRepository redisRepository;

    @Override
    public void execute(String document) {

        var redisEntity = redisRepository.findById(document);

        log.info("Subscribe : Payload {} / Queue {}", redisEntity, "queue_fail_document");
        //redisEntity.ifPresent(redisRepository::delete);


    }
}
