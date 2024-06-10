package br.com.acmePay.adapters.input.api;

import br.com.acmePay.adapters.input.api.request.CustomerRequest;
import br.com.acmePay.adapters.input.api.response.CustomerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/customer")
public interface ICustomerResourceAPI {

    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest request);

    @GetMapping
    public List<CustomerResponse> list();


}
