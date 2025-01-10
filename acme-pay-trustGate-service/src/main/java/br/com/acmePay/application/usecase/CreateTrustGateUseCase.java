package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.TrustGateDomain;
import br.com.acmePay.application.ports.in.ICreateTrustGateUseCase;
import br.com.acmePay.application.ports.out.ICreateTrustGate;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateTrustGateUseCase implements ICreateTrustGateUseCase {

    private ICreateTrustGate createTrustGate;

    @Override
    public void execute(TrustGateDomain domain) {
        domain.create(createTrustGate);
    }
}
