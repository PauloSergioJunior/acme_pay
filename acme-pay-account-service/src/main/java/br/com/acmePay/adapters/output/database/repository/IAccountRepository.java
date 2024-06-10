package br.com.acmePay.adapters.output.database.repository;

import br.com.acmePay.adapters.output.database.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {

    public AccountEntity findByNumber(Integer number);

}
