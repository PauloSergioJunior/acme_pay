package br.com.acmePay.application.domain;

import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.domain.exception.ValidDocumentException;
import br.com.acmePay.application.ports.out.ICreateAccount;
import br.com.acmePay.application.ports.out.IDeleteAccount;
import br.com.acmePay.application.ports.out.IListAccount;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private String document;
    private Boolean close;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateAccount createAccount) {
        createAccount.execute(this);
    }

    public void delete(IDeleteAccount iDeleteAccount) {
        iDeleteAccount.execute(this);
    }

//    public List<AccountDomain> listAccount(IListAccount iListAccount){
//       return iListAccount.execute();
//    }

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0){
            this.balance = this.balance.subtract(amount);
        }else {
            throw new BalanceToWithdrawException("error withdraw");
        }
    }

    public void validDocument(String document) throws ValidDocumentException {

        if (document == null || document.length() < 11) {
            throw new ValidDocumentException("Document Invalid");
        }

    }
}