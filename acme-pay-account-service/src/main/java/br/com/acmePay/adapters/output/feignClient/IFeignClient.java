package br.com.acmePay.adapters.output.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;

@ApiIgnore
@FeignClient(value = "customer-service", url = "http://localhost:8087/customer-service/api/v1/customer")
public interface IFeignClient {

    @GetMapping(value = "/salary/{document}")
    BigDecimal findSalary(@PathVariable("document") String document);
}
