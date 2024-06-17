package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.NotificationDomain;

import java.util.List;

public interface IFindNotification {

    List<NotificationDomain> execute();
}
