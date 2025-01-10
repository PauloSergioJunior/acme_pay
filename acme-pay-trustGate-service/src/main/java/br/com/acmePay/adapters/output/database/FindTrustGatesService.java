package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.repository.ITrustGateRepository;
import br.com.acmePay.application.domain.TrustGateDomain;
import br.com.acmePay.application.ports.out.IFindTrustGate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FindTrustGatesService implements IFindTrustGate {

    private ITrustGateRepository repository;

    @Override
    public List<TrustGateDomain> execute() {

        return repository.findAll().stream()
                    .map(e -> TrustGateDomain.builder()
                            .id(e.getId())
                            .document(e.getDocument())
                            .status_document(e.getStatus_document())
                            .created_at(e.getCreated_at())
                            .updated_at(e.getUpdated_at())
                            .build())
                    .toList();

    }
}
