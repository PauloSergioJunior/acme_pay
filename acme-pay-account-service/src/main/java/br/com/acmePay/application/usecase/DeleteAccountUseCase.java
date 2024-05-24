package br.com.acmePay.application.usecase;

import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.ValidDocumentException;
import br.com.acmePay.application.ports.in.ICreateAccountUseCase;
import br.com.acmePay.application.ports.in.IDeleteAccountUseCase;
import br.com.acmePay.application.ports.out.ICreateAccount;
import br.com.acmePay.application.ports.out.IDeleteAccount;
import br.com.acmePay.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class DeleteAccountUseCase implements IDeleteAccountUseCase {

    private final IDeleteAccount deleteAccount;

    @Override
    public void execute(AccountDomain domain)  {
        domain.delete(deleteAccount);
    }

}
