package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.repository.INotificationRepository;
import br.com.acmePay.adapters.output.queue.IProducerMessage;
import br.com.acmePay.application.domain.enums.StatusDocument;
import br.com.acmePay.application.ports.out.IFindStatusNotificationByDoc;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindStatusByDocService implements IFindStatusNotificationByDoc {

    private INotificationRepository repository;
    private IProducerMessage producerMessage;

    @Override
    public void execute(String document) {

        String statusDocument;
        var notification = repository.findByDocument(document);

        if (notification.isPresent()) {
            statusDocument = notification.get().getStatus_document();
        }else{
            statusDocument = StatusDocument.SUSPENDED;
        }

      producerMessage.publish(statusDocument, document);
    }
}
