package br.com.acmePay.application.domain;

import br.com.acmePay.adapters.output.database.entity.AccountRedisEntity;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.domain.exception.ValidDocumentException;
import br.com.acmePay.application.ports.out.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    private String email;

    public void create(ICreateRedisAccount iCreateTemporaryAccount, ICheckDocumentCustomer checkDocumentCustomer) {

        iCreateTemporaryAccount.execute(this);

        checkDocumentCustomer.execute(this.document);

    }

    public void delete(IDeleteAccount iDeleteAccount) {
        iDeleteAccount.execute(this);
    }

    public List<AccountDomain> listAccount(IListAccount iListAccount){
       return iListAccount.execute();
    }

    public void transfer(ITransfer transfer, AccountDomain  accountDestiny, BigDecimal amount) throws BalanceToWithdrawException {
            transfer.execute(this,accountDestiny,amount);

    }

    public void deposit(IDeposit deposit, BigDecimal amount){

        deposit.execute(this,amount);

    }

    public void withdraw(IWithdraw withdraw, BigDecimal amount) throws BalanceToWithdrawException {

        withdraw.execute(this, amount);

    }

    public void validDocument(ICreateAccount createAccount, String document) {

        createAccount.execute(document);

    }

    public void invalidDocument(IDeleteRedisAccount deleteRedisAccount, String document) {
        deleteRedisAccount.execute(document);
    }

    public BigDecimal limitCard(ILimitCard limitCard){

        var salary = limitCard.execute(this.document);
        var min = BigDecimal.valueOf(0.1);
        var med = BigDecimal.valueOf(0.3);
        var max = BigDecimal.valueOf(0.5);
        var limit = BigDecimal.ZERO;

        if(salary.compareTo(BigDecimal.valueOf(10000)) < 0){
            limit = min.multiply(salary);
        } else if (salary.compareTo(BigDecimal.valueOf(10000)) >= 0 && salary.compareTo(BigDecimal.valueOf(15000)) <= 0) {
            limit = med.multiply(salary);
        } else if (salary.compareTo(BigDecimal.valueOf(15000)) > 0) {
            limit = max.multiply(salary);
        }

        return limit.setScale(2);
    }


}