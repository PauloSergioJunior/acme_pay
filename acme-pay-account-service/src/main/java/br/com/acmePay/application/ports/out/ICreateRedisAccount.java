package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.AccountDomain;

public interface ICreateRedisAccount {

    void execute(AccountDomain account);
}
