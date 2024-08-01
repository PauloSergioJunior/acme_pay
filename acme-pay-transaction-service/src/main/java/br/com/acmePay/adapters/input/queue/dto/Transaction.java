package br.com.acmePay.adapters.input.queue.dto;

import br.com.acmePay.constants.ConstantsTypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private KafkaDTO accountOrigin;
    private KafkaDTO accountDestiny;
    private String dateTransfer;
    private BigDecimal transferValue;
    private ConstantsTypeTransaction typeTransaction;

}
