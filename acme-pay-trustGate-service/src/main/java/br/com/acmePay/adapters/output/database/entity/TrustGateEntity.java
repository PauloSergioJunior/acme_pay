package br.com.acmePay.adapters.output.database.entity;


import br.com.acmePay.application.domain.enums.StatusDocument;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "trust_gate")
public class TrustGateEntity {

    @Id
    @SequenceGenerator(name = "trustGate_seq",
            sequenceName = "trustGate_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "trustGate_seq")
    private Long id;

    private String document;
    private String status_document;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
