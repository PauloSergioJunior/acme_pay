package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.in.IDepositUseCase;
import br.com.acmePay.application.ports.out.IDeposit;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class DepositUseCase implements IDepositUseCase {

    private final IDeposit deposit;

    @Override
    public void execute(BigDecimal amount, AccountDomain domain) {
        domain.deposit(deposit, amount);
    }


}
