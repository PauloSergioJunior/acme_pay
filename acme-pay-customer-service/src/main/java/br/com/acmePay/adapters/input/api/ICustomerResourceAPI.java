package br.com.acmePay.adapters.input.api;

import br.com.acmePay.adapters.input.api.request.CustomerRequest;
import br.com.acmePay.adapters.input.api.response.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RequestMapping("/api/v1/customer")
public interface ICustomerResourceAPI {

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest request);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CustomerResponse> list();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(("/salary/{document}"))
    public BigDecimal findWage(@PathVariable("document") String document);


}
