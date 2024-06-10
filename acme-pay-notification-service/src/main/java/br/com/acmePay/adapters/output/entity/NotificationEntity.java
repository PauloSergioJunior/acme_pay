package br.com.acmePay.adapters.output.entity;


import br.com.acmePay.application.domain.enums.StatusDocumet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id
    @SequenceGenerator(name = "notification_seq",
            sequenceName = "notification_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notification_seq")
    private Long id;

    private String document;
    @Enumerated(EnumType.ORDINAL)
    private Enum<StatusDocumet> statusDocument;

}
