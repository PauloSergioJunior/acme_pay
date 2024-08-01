package br.com.acmePay.application.ports.in;

import java.math.BigDecimal;

public interface ISalaryUseCase {

    BigDecimal execute(String document);

}
