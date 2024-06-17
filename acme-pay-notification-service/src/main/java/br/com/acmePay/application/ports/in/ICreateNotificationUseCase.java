package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.NotificationDomain;

public interface ICreateNotificationUseCase {

    void execute(NotificationDomain domain);

}
