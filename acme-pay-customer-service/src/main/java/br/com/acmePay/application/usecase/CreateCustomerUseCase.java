package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.CustomerDomain;
import br.com.acmePay.application.ports.in.ICreateCustomerUseCase;
import br.com.acmePay.application.ports.out.ICreateCustomer;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@UseCase
@AllArgsConstructor
public class CreateCustomerUseCase implements ICreateCustomerUseCase {

    private final ICreateCustomer createCustomer;

    @Override
    public void execute(CustomerDomain domain) {

        domain.create(createCustomer);
    }
}
