package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.CustomerDomain;
import br.com.acmePay.application.ports.in.ISalaryUseCase;
import br.com.acmePay.application.ports.out.ISalary;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class SalaryUseCase implements ISalaryUseCase {

    private final ISalary salary;

    @Override
    public BigDecimal execute(String document) {

        var domain = CustomerDomain.builder()
                .document(document)
                .build();

        return domain.findWageByDocument(salary);
    }
}
