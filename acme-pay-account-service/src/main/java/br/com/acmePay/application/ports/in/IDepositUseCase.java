package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.AccountDomain;

import java.math.BigDecimal;

public interface IDepositUseCase {
    void execute(BigDecimal amount, AccountDomain domain);
}
