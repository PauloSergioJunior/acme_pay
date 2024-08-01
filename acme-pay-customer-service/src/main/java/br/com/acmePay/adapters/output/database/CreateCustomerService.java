package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.output.database.entity.CustomerEntity;
import br.com.acmePay.adapters.output.database.repository.ICustomerRepository;
import br.com.acmePay.application.domain.CustomerDomain;
import br.com.acmePay.application.ports.out.ICreateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreateCustomerService implements ICreateCustomer {

    private final ICustomerRepository repository;

    @Override
    public void execute(CustomerDomain domain) {

         var entity = CustomerEntity.builder()
                        .created_at(LocalDateTime.now())
                        .updated_at(null)
                        .name(domain.getName())
                        .document(domain.getDocument())
                        .email(domain.getEmail())
                        .phone(domain.getPhone())
                        .salary(domain.getSalary())
                        .build();


        repository.save(entity);
    }
}
