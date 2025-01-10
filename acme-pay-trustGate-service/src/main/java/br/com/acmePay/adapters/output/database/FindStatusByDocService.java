package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.repository.ITrustGateRepository;
import br.com.acmePay.adapters.output.queue.IProducerMessage;
import br.com.acmePay.application.domain.enums.StatusDocument;
import br.com.acmePay.application.ports.out.IFindStatusTrustGateByDoc;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindStatusByDocService implements IFindStatusTrustGateByDoc {

    private ITrustGateRepository repository;
    private IProducerMessage producerMessage;

    @Override
    public void execute(String document) {

        String statusDocument;
        var trustGate = repository.findByDocument(document);

        if (trustGate.isPresent()) {
            statusDocument = trustGate.get().getStatus_document();
        }else{
            statusDocument = StatusDocument.ACTIVE;
        }

      producerMessage.publish(statusDocument, document);
    }
}
