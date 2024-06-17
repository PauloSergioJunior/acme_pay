package br.com.acmePay.application.domain;

import br.com.acmePay.application.domain.enums.StatusDocument;
import br.com.acmePay.application.ports.out.ICreateNotification;
import br.com.acmePay.application.ports.out.IFindNotification;
import br.com.acmePay.application.ports.out.IFindStatusNotificationByDoc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDomain {

    private Long id;
    private String document;
    private String status_document;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateNotification createNotification){

        createNotification.execute(this);

    }

    public List<NotificationDomain> getDocument(IFindNotification findNotification){
        return findNotification.execute();
    }

    public void statusDocument(String document, IFindStatusNotificationByDoc notificationByDoc){
         notificationByDoc.execute(document);
    }

}