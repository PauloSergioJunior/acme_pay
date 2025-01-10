package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.TrustGateDomain;

public interface ICreateTrustGateUseCase {

    void execute(TrustGateDomain domain);

}
