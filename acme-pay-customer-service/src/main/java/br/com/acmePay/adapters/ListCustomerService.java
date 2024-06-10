package br.com.acmePay.adapters;

import br.com.acmePay.adapters.output.repository.ICustomerRepository;
import br.com.acmePay.application.domain.CustomerDomain;
import br.com.acmePay.application.ports.out.IListCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListCustomerService implements IListCustomer {

    private final ICustomerRepository repository;

    @Override
    public List<CustomerDomain> execute() {

        return repository.findAll()
                        .stream()
                                .map(c -> CustomerDomain.builder()
                                        .id(c.getId())
                                        .name(c.getName())
                                        .email(c.getEmail())
                                        .phone(c.getPhone())
                                        .document(c.getDocument())
                                        .created_at(c.getCreated_at())
                                        .updated_at(c.getUpdated_at())
                                        .build())
                                .toList();

    }

}
