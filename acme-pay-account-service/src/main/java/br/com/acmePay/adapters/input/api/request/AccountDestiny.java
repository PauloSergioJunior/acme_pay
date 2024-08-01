package br.com.acmePay.adapters.input.api.request;

import br.com.acmePay.constants.ConstantsTypeTransaction;
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
public class AccountDestiny implements Serializable {

    private Integer number;
    private Integer agency;
    private String document;
    private BigDecimal transferValue;
    private ConstantsTypeTransaction typeTransaction;
}
