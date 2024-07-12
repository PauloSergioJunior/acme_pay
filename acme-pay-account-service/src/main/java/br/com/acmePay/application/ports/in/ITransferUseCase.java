package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;

import java.math.BigDecimal;

public interface ITransferUseCase {
    void execute(AccountDomain accountOrigin, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException;
}
