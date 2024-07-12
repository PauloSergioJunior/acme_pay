package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;

import java.math.BigDecimal;

public interface IWithdrawUseCase {

    void execute(BigDecimal amount, AccountDomain domain) throws BalanceToWithdrawException;
}
