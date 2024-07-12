package br.com.acmePay.adapters.input.api.request;

import br.com.acmePay.constants.ConstantsTypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest implements Serializable {

    private Integer number;
    private Integer agency;
    private String document;
    private LocalDateTime dateTransfer;
    private BigDecimal transferValue;
    private ConstantsTypeTransaction typeTransaction;
    private TransactionRequest accountDestiny;

}
