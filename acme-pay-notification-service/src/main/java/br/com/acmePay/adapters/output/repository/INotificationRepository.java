package br.com.acmePay.adapters.output.repository;

import br.com.acmePay.adapters.output.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
