package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.TrustGateEntity;
import br.com.acmePay.adapters.output.database.repository.ITrustGateRepository;
import br.com.acmePay.application.domain.TrustGateDomain;
import br.com.acmePay.application.ports.out.ICreateTrustGate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateTrustGateService implements ICreateTrustGate {

    private ITrustGateRepository repository;

    @Override
    public void execute(TrustGateDomain domain) {

        var trustGateEntity = TrustGateEntity.builder()
                                    .document(domain.getDocument())
                                    .status_document(domain.getStatus_document())
                                    .created_at(domain.getCreated_at())
                                    .updated_at(null)
                                    .build();

        repository.save(trustGateEntity);
    }
}
