package br.com.acmePay.adapters.input.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest implements Serializable {

    private Integer number;
    private Integer agency;
    private String document;
    private BigDecimal transferValue;
    private AccountDestiny accountDestiny;

}
