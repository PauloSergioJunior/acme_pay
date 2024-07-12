package br.com.acmePay.adapters.output.database.repository;

import br.com.acmePay.adapters.output.database.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByNumber(Integer number);
    Optional<AccountEntity> findByDocumentAndNumberAndAgency(String document, Integer number, Integer agency);
}
