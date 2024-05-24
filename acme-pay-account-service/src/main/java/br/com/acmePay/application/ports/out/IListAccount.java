package br.com.acmePay.application.ports.out;


import br.com.acmePay.application.domain.AccountDomain;

import java.util.List;

public interface IListAccount {

    List<AccountDomain> execute();
}
