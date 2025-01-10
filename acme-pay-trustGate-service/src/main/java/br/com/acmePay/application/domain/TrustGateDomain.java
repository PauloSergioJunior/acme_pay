package br.com.acmePay.application.domain;

import br.com.acmePay.application.domain.enums.StatusDocument;
import br.com.acmePay.application.ports.out.ICreateTrustGate;
import br.com.acmePay.application.ports.out.IFindTrustGate;
import br.com.acmePay.application.ports.out.IFindStatusTrustGateByDoc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrustGateDomain {

    private Long id;
    private String document;
    private String status_document;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateTrustGate createTrustGate){

        createTrustGate.execute(this);

    }

    public List<TrustGateDomain> getDocument(IFindTrustGate findTrustGate){
        return findTrustGate.execute();
    }

    public void statusDocument(String document, IFindStatusTrustGateByDoc trustGateByDoc){
         trustGateByDoc.execute(document);
    }

}