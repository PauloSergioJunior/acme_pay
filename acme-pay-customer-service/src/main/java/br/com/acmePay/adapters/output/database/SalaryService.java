package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.CustomerEntity;
import br.com.acmePay.adapters.output.database.repository.ICustomerRepository;
import br.com.acmePay.application.ports.out.ISalary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class SalaryService implements ISalary {

    private final ICustomerRepository repository;

    @Override
    public BigDecimal execute(String document) {

        var entityOptional = repository.findByDocument(document);

        return entityOptional.map(CustomerEntity::getSalary).orElse(BigDecimal.ZERO);

    }
}
