package br.com.acmePay.application.ports.out;

import java.math.BigDecimal;

public interface ILimitCard {
    BigDecimal execute(String document);
}
