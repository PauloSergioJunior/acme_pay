package br.com.acmePay.adapters.output.repository;

import br.com.acmePay.adapters.output.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {

    public AccountEntity findByNumber(Integer number);

}
