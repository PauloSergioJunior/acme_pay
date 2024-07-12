package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.ports.in.IWithdrawUseCase;
import br.com.acmePay.application.ports.out.IWithdraw;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class WithdrawUseCase implements IWithdrawUseCase {

    private final IWithdraw withdraw;

    @Override
    public void execute(BigDecimal amount, AccountDomain domain) throws BalanceToWithdrawException {
        domain.withdraw(withdraw, amount);
    }
}
