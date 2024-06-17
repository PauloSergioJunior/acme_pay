package br.com.acmePay.adapters.output.database.repository;

import br.com.acmePay.adapters.output.database.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotificationRepository extends JpaRepository<NotificationEntity, Long> {

    NotificationEntity findByDocument(String document);

}
