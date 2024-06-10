package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.CustomerDomain;
import br.com.acmePay.application.ports.in.IListCustomerUseCase;
import br.com.acmePay.application.ports.out.IListCustomer;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@UseCase
@AllArgsConstructor
public class ListCustomerUseCase implements IListCustomerUseCase {

    private final IListCustomer iListCustomer;

    @Override
    public List<CustomerDomain> execute() {

        var customerDomain = CustomerDomain.builder().build();

        return customerDomain.listCustomer(iListCustomer);

    }

}
