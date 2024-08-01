package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.in.ILimitCardUseCase;
import br.com.acmePay.application.ports.out.ILimitCard;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class LimitCardUseCase implements ILimitCardUseCase {

    private ILimitCard limitCard;

    @Override
    public BigDecimal execute(String document) {

        var domain = AccountDomain.builder().document(document).build();

        return domain.limitCard(limitCard);
    }
}
