package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.CustomerDomain;

public interface ICreateCustomerUseCase {

   void execute(CustomerDomain domain);

}
