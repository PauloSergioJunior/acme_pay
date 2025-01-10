package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.TrustGateDomain;

public interface ICreateTrustGate {
    void execute(TrustGateDomain domain);
}
