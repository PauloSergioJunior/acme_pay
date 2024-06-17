package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.repository.INotificationRepository;
import br.com.acmePay.application.domain.NotificationDomain;
import br.com.acmePay.application.ports.out.IFindNotification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FindNotificationsService implements IFindNotification {

    private INotificationRepository repository;

    @Override
    public List<NotificationDomain> execute() {

        return repository.findAll().stream()
                    .map(e -> NotificationDomain.builder()
                            .id(e.getId())
                            .document(e.getDocument())
                            .status_document(e.getStatus_document())
                            .created_at(e.getCreated_at())
                            .updated_at(e.getUpdated_at())
                            .build())
                    .toList();

    }
}
