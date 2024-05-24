package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.AccountDomain;

import java.util.List;

public interface IListAccountUseCase {
    List<AccountDomain> execute();
}
