package br.com.acmePay.adapters.input.controller;

import br.com.acmePay.adapters.input.api.IAccountResourceAPI;
import br.com.acmePay.adapters.input.api.request.AccountRequest;
import br.com.acmePay.adapters.input.api.response.AccountResponse;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.ValidDocumentException;
import br.com.acmePay.application.ports.in.ICreateAccountUseCase;
import br.com.acmePay.application.ports.in.IDeleteAccountUseCase;
import br.com.acmePay.application.ports.in.IListAccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
public class AccountController implements IAccountResourceAPI {

    private final ICreateAccountUseCase createAccountUseCase;
    private final IDeleteAccountUseCase deleteAccountUseCase;
    private final IListAccountUseCase listAccountUseCase;

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


}
