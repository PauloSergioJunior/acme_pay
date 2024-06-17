package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.NotificationDomain;
import br.com.acmePay.application.ports.in.ICreateNotificationUseCase;
import br.com.acmePay.application.ports.out.ICreateNotification;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateNotificationUseCase implements ICreateNotificationUseCase {

    private ICreateNotification createNotification;

    @Override
    public void execute(NotificationDomain domain) {
        domain.create(createNotification);
    }
}
