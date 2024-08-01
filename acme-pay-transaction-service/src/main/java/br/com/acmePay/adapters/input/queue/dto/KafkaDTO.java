package br.com.acmePay.adapters.input.queue.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KafkaDTO {

    private Integer number;
    private Integer agency;
    private String document;
}
