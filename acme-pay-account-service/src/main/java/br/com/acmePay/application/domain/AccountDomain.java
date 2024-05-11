package br.com.acmePay.application.domain;

import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDomain {

    private Long id;
    private Integer accountNumber;
    private Integer agencyNumber;
    private BigDecimal balance;
    private Boolean close;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;



    public void create(AccountDomain account) {

    }

    public void deposit(BigDecimal amount){
        this.balance = this.balance.add(amount);

    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException{

        checkBalance(amount);
        this.balance = this.balance.subtract(amount);

    }

    public void transfer(AccountDomain targetAccount, BigDecimal valueTranfer) throws BalanceToWithdrawException {
        this.withdraw(valueTranfer);
        targetAccount.deposit(valueTranfer);
    }

    private void checkBalance(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) < 0){
            throw new BalanceToWithdrawException("error withdraw");
        }

    }

}
