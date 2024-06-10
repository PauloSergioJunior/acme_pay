package br.com.acmePay.application.ports.out;

import br.com.acmePay.application.domain.CustomerDomain;

import java.util.List;

public interface IListCustomer {
    
    List<CustomerDomain> execute();
    
}
