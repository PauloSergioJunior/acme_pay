package br.com.acmePay.application.ports.out;


import br.com.acmePay.application.domain.AccountDomain;

public interface ICreateAccount {

    void createDomain(AccountDomain accountDomain);
    void execute(String document);
}
