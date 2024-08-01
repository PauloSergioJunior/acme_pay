package br.com.acmePay.adapters.output.feignClient.service;

import br.com.acmePay.adapters.output.feignClient.IFeignClient;
import br.com.acmePay.application.ports.out.ILimitCard;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class LimitCardService implements ILimitCard {

    private final IFeignClient feignClient;

    @Override
    public BigDecimal execute(String document) {

        return feignClient.findSalary(document);

    }
}