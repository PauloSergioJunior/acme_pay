package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;

import java.math.BigDecimal;

public interface IWithdraw {

    void execute(AccountDomain domain, BigDecimal amount) throws BalanceToWithdrawException;
}
