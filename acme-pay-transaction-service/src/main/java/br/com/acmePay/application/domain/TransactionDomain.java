package br.com.acmePay.application.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class TransactionDomain {

    private UUID transactionId;
    private BigDecimal transactionValue;
    private LocalDate transactionDate;
    private Integer accountId;


}
