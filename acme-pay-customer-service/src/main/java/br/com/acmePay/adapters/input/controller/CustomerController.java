package br.com.acmePay.adapters.input.controller;

import br.com.acmePay.adapters.input.api.ICustomerResourceAPI;
import br.com.acmePay.adapters.input.api.request.CustomerRequest;
import br.com.acmePay.adapters.input.api.response.CustomerResponse;
import br.com.acmePay.application.domain.CustomerDomain;
import br.com.acmePay.application.ports.in.ICreateCustomerUseCase;
import br.com.acmePay.application.ports.in.IListCustomerUseCase;
import br.com.acmePay.application.ports.in.ISalaryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController implements ICustomerResourceAPI {

    private final ICreateCustomerUseCase customerUseCase;
    private final IListCustomerUseCase listCustomerUseCase;
    private final ISalaryUseCase salaryUseCase;

    @Override
    public CustomerResponse create(CustomerRequest request) {

        var domain = CustomerDomain.builder()
                        .name(request.getName())
                        .phone(request.getPhone())
                        .document(request.getDocument())
                        .email(request.getEmail())
                        .build();

        customerUseCase.execute(domain);

        return CustomerResponse.builder()
                .message("Customer created")
                .build();
    }

    @Override
    public List<CustomerResponse> list() {
        return listCustomerUseCase.execute()
                .stream()
                .map(g -> CustomerResponse.builder()
                        .message(g.toString())
                        .build())
                .toList();
    }

    @Override
    public BigDecimal findWage(String document) {

        return salaryUseCase.execute(document);

    }

}
