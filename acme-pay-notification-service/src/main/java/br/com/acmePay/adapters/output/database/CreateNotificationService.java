package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.NotificationEntity;
import br.com.acmePay.adapters.output.database.repository.INotificationRepository;
import br.com.acmePay.application.domain.NotificationDomain;
import br.com.acmePay.application.ports.out.ICreateNotification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateNotificationService implements ICreateNotification {

    private INotificationRepository repository;

    @Override
    public void execute(NotificationDomain domain) {

        var notificationEntity = NotificationEntity.builder()
                                    .document(domain.getDocument())
                                    .status_document(domain.getStatus_document())
                                    .created_at(domain.getCreated_at())
                                    .updated_at(null)
                                    .build();

        repository.save(notificationEntity);
    }
}
