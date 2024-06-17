package br.com.acmePay.adapters.input.api.request;

import br.com.acmePay.application.domain.enums.StatusDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequest {

    private String document;
    private String statusDocument;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
