package br.com.acmePay.application.ports.in;

import br.com.acmePay.application.domain.CustomerDomain;

import java.util.List;

public interface IListCustomerUseCase {

    List<CustomerDomain> execute();

}
