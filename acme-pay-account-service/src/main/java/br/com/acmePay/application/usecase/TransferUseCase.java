package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.ports.in.ITransferUseCase;
import br.com.acmePay.application.ports.out.ITransfer;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class TransferUseCase implements ITransferUseCase {

    private final ITransfer transfer;

    @Override
    public void execute(AccountDomain accountOrigin, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException {

        accountOrigin.transfer(transfer, accountDestiny, amount);

    }
}
