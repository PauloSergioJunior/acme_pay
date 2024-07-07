package br.com.acmePay.application.ports.out;

import br.com.acmePay.adapters.output.database.entity.AccountEntity;

public interface IDeleteRedisAccount {

    void execute(String document);
}
