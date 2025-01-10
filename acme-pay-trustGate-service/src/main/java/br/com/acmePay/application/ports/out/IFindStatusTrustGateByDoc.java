package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.enums.StatusDocument;

public interface IFindStatusTrustGateByDoc {
    void execute(String document);
}
