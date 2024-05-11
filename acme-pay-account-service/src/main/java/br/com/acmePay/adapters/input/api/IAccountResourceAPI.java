package br.com.acmePay.adapters.input.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/accounts")
public interface IAccountResourceAPI {
    @GetMapping("/test")
    String test();
}
