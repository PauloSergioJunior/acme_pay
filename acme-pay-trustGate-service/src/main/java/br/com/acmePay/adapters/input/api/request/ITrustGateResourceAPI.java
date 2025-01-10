package br.com.acmePay.adapters.input.api.request;

import br.com.acmePay.adapters.input.api.response.TrustGateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/trustGates")
public interface ITrustGateResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    TrustGateResponse create(@RequestBody TrustGateRequest request);

//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/{numberAccount}")
//    TrustGateResponse delete(@PathVariable("numberAccount") Integer numberAccount) ;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<TrustGateResponse> getTrustGates() ;
}
