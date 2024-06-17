package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.NotificationDomain;
import br.com.acmePay.application.ports.in.IFindStatusByDocUseCase;
import br.com.acmePay.application.ports.out.IFindStatusNotificationByDoc;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class FindStatusByDocUseCase implements IFindStatusByDocUseCase {

    private IFindStatusNotificationByDoc notificationByDoc;

    @Override
    public void execute(String document) {
        var notificationDomain = NotificationDomain.builder().build();

        notificationDomain.statusDocument(document, notificationByDoc);
    }
}
