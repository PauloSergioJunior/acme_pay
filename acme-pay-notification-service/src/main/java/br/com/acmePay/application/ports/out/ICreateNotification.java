package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.NotificationDomain;

public interface ICreateNotification {
    void execute(NotificationDomain domain);
}
