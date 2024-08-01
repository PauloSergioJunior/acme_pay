package br.com.acmePay.application.ports.out;

import java.math.BigDecimal;

public interface ISalary {
    BigDecimal execute(String document);
}
