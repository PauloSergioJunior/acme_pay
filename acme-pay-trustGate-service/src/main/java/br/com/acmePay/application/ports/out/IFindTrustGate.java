package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.TrustGateDomain;

import java.util.List;

public interface IFindTrustGate {

    List<TrustGateDomain> execute();
}
