package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;

import java.math.BigDecimal;

public interface ITransfer {
    void execute(AccountDomain accountOrigin, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException;
}
