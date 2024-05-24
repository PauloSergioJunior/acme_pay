package br.com.acmePay.application.ports.out;


import br.com.acmePay.application.domain.AccountDomain;

public interface IDeleteAccount {

    void execute(AccountDomain accountDomain);
}
