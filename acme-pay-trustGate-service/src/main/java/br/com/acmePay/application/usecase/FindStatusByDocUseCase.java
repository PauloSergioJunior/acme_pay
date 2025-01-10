package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.TrustGateDomain;
import br.com.acmePay.application.ports.in.IFindStatusByDocUseCase;
import br.com.acmePay.application.ports.out.IFindStatusTrustGateByDoc;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class FindStatusByDocUseCase implements IFindStatusByDocUseCase {

    private IFindStatusTrustGateByDoc trustGateByDoc;

    @Override
    public void execute(String document) {
        var trustGateDomain = TrustGateDomain.builder().build();

        trustGateDomain.statusDocument(document, trustGateByDoc);
    }
}
