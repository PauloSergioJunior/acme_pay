package br.com.acmePay.adapters.input.controller;

import br.com.acmePay.adapters.input.api.request.INotificationResourceAPI;
import br.com.acmePay.adapters.input.api.request.NotificationRequest;
import br.com.acmePay.adapters.input.api.response.NotificationResponse;
import br.com.acmePay.application.domain.NotificationDomain;
import br.com.acmePay.application.domain.enums.StatusDocument;
import br.com.acmePay.application.ports.in.ICreateNotificationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
public class NotificationController implements INotificationResourceAPI {

    private ICreateNotificationUseCase createNotification;

    @Override
    public NotificationResponse create(NotificationRequest request) {

        var notificationDomain = NotificationDomain.builder()
                .document(request.getDocument())
                .status_document(StatusDocument.SUSPENDED)
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .build();

        createNotification.execute(notificationDomain);

        return NotificationResponse.builder().message("Document Created").build();

    }

    @Override
    public List<NotificationResponse> getNotifications() {
        return List.of();
    }

}

