package br.com.acmePay.adapters.output.database.repository;

import br.com.acmePay.adapters.output.database.entity.AccountRedisEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAccountRedisRepository extends CrudRepository<AccountRedisEntity, String> {

}
