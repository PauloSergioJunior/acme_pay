package br.com.acmePay.adapters.input.controller;

import br.com.acmePay.adapters.input.api.IAccountResourceAPI;
import br.com.acmePay.adapters.input.api.request.AccountRequest;
import br.com.acmePay.adapters.input.api.request.TransactionRequest;
import br.com.acmePay.adapters.input.api.response.AccountResponse;
import br.com.acmePay.adapters.output.queue.dto.Transaction;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.domain.exception.ValidDocumentException;
import br.com.acmePay.application.ports.in.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
public class AccountController implements IAccountResourceAPI {

    private final ICreateAccountUseCase createAccountUseCase;
    private final IDeleteAccountUseCase deleteAccountUseCase;
    private final IListAccountUseCase listAccountUseCase;
    private final IDepositUseCase depositUseCase;
    private final IWithdrawUseCase withdrawUseCase;
    private final ITransferUseCase transferUseCase;
    private final ILimitCardUseCase limitCardUseCase;

    @Override
    public AccountResponse create(AccountRequest request)  {

        try {
            var domain = AccountDomain.builder()
                    .created_at(LocalDateTime.now())
                    .updated_at(null)
                    .close(false)
                    .agency(request.getAgency())
                    .number(request.getNumber())
                    .document(request.getDocument())
                    .balance(request.getBalance())
                    .build();

            createAccountUseCase.execute(domain);

            return AccountResponse.builder()
                    .message("account created!")
                    .build();

        }catch (ValidDocumentException e){

            return AccountResponse.builder()
                    .message(e.getMessage())
                    .build();
        }


    }

    @Override
    public AccountResponse delete(Integer numberAccount) {

        var domain = AccountDomain.builder()
                .created_at(null)
                .updated_at(LocalDateTime.now())
                .close(true)
                .agency(null)
                .number(numberAccount)
                .document(null)
                .balance(null)
                .build();

        deleteAccountUseCase.execute(domain);

        return AccountResponse.builder()
                .message("account created!")
                .build();
    }

    @Override
    public List<AccountResponse> getAccounts() {

        return listAccountUseCase.execute()
                .stream()
                .map(e -> AccountResponse.builder()
                        .message(e.toString())
                        .build())
                .toList();
    }

    @Override
    public AccountResponse deposit(Transaction transactionRequest) {

        var amount = transactionRequest.getTransferValue();

        var domain = AccountDomain.builder()
                .close(false)
                .agency(transactionRequest.getAccountOrigin().getAgency())
                .number(transactionRequest.getAccountOrigin().getNumber())
                .document(transactionRequest.getAccountOrigin().getDocument())
                .build();

        depositUseCase.execute(amount, domain);

        return AccountResponse.builder()
                .message("deposit made!")
                .build();
    }

    @Override
    public AccountResponse withdraw(Transaction transactionRequest) throws BalanceToWithdrawException {

        try {

            var amount = transactionRequest.getTransferValue();

            var domain = AccountDomain.builder()
                    .close(false)
                    .agency(transactionRequest.getAccountOrigin().getAgency())
                    .number(transactionRequest.getAccountOrigin().getNumber())
                    .document(transactionRequest.getAccountOrigin().getDocument())
                    .build();

            withdrawUseCase.execute(amount, domain);

            return AccountResponse.builder()
                    .message("withdraw made!")
                    .build();

        }catch (BalanceToWithdrawException e){

            return AccountResponse.builder()
                    .message(e.getMessage())
                    .build();
        }


    }

    @Override
    public AccountResponse transfer(Transaction transactionRequest) throws BalanceToWithdrawException {

        try {

            var amount = transactionRequest.getTransferValue();

            var domain = AccountDomain.builder()
                    .close(false)
                    .agency(transactionRequest.getAccountOrigin().getAgency())
                    .number(transactionRequest.getAccountOrigin().getNumber())
                    .document(transactionRequest.getAccountOrigin().getDocument())
                    .build();

            var transactionRequestDestiny = transactionRequest.getAccountDestiny();

            var domainDestiny = AccountDomain.builder()
                    .close(false)
                    .agency(transactionRequestDestiny.getAgency())
                    .number(transactionRequestDestiny.getNumber())
                    .document(transactionRequestDestiny.getDocument())
                    .build();

            transferUseCase.execute(domain, domainDestiny, amount);

            return AccountResponse.builder()
                    .message("transfer made!")
                    .build();

        }catch (BalanceToWithdrawException e){

            return AccountResponse.builder()
                    .message(e.getMessage())
                    .build();
        }
    }

    @Override
    public AccountResponse getLimitCard(String document) {

       var limit = limitCardUseCase.execute(document);

       return AccountResponse.builder()
                .message(limit.toString())
                .build();
    }


}
