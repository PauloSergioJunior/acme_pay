package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.AccountDomain;

import java.math.BigDecimal;

public interface IDeposit {
    void execute(AccountDomain domain, BigDecimal amount);
}
