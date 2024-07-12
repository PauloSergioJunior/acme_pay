package br.com.acmePay.adapters.input.api;

import br.com.acmePay.adapters.input.api.request.AccountRequest;
import br.com.acmePay.adapters.input.api.request.TransactionRequest;
import br.com.acmePay.adapters.input.api.response.AccountResponse;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.domain.exception.ValidDocumentException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "account-service")
@RequestMapping("/api/v1/accounts")
public interface IAccountResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    AccountResponse create(@RequestBody AccountRequest request) throws ValidDocumentException;

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{numberAccount}")
    AccountResponse delete(@PathVariable("numberAccount") Integer numberAccount) ;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<AccountResponse> getAccounts() ;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/deposit")
    AccountResponse deposit(@RequestBody TransactionRequest transactionRequest);

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/withdraw")
    AccountResponse withdraw(@RequestBody TransactionRequest transactionRequest) throws BalanceToWithdrawException;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/transfer")
    AccountResponse transfer(@RequestBody TransactionRequest transactionRequest) throws BalanceToWithdrawException;

}
