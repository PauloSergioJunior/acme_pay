package br.com.acmePay.adapters.output;

import br.com.acmePay.adapters.output.entity.AccountEntity;
import br.com.acmePay.adapters.output.repository.IAccountRepository;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.out.IDeleteAccount;
import br.com.acmePay.application.ports.out.IListAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ListAccountService implements IListAccount {

    private final IAccountRepository repository;

    @Override
    public List<AccountDomain> execute() {
        var accounts = repository.findAll();

        return  accounts.stream()
                    .filter(e -> !e.getClose())
                    .map(a -> AccountDomain.builder()
                            .created_at(a.getCreated_at())
                            .updated_at(a.getUpdated_at())
                            .close(a.getClose())
                            .agency(a.getAgency())
                            .number(a.getNumber())
                            .document(a.getDocument())
                            .balance(a.getBalance())
                            .build())
                    .toList();
    }
}
