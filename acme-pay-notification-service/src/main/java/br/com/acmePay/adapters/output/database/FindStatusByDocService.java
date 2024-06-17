package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.repository.INotificationRepository;
import br.com.acmePay.adapters.output.queue.IProducerMessage;
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

      String statusDocument = repository.findByDocument(document).getStatus_document();

      producerMessage.publish(statusDocument);
    }
}
