package br.com.acmePay.application.ports.in;

import java.math.BigDecimal;

public interface ILimitCardUseCase {
    BigDecimal execute(String document);
}
