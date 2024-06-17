package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.enums.StatusDocument;

public interface IFindStatusNotificationByDoc {
    void execute(String document);
}
