package br.com.acmePay.adapters.output.database;

import br.com.acmePay.adapters.input.api.request.TransactionRequest;
import br.com.acmePay.adapters.output.database.entity.AccountEntity;
import br.com.acmePay.adapters.output.database.repository.IAccountRepository;
import br.com.acmePay.adapters.output.queue.producer.kafka.ISendMessage;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.ports.out.ITransfer;
import br.com.acmePay.constants.ConstantsKafka;
import br.com.acmePay.constants.ConstantsTypeTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TransferService implements ITransfer {

    private final IAccountRepository accountRepository;
    private final ISendMessage sendMessage;

    @Override
    public void execute(AccountDomain accountOrigin, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException {

        var document = accountOrigin.getDocument();
        var number = accountOrigin.getNumber();
        var agency = accountOrigin.getAgency();

        var documentDestiny = accountDestiny.getDocument();
        var numberDestiny = accountDestiny.getNumber();
        var agencyDestiny = accountDestiny.getAgency();

        var optionalOrigin = accountRepository.findByDocumentAndNumberAndAgency(document, number, agency);
        var optionalDestiny = accountRepository.findByDocumentAndNumberAndAgency(documentDestiny, numberDestiny, agencyDestiny);

        if (optionalOrigin.isPresent() && optionalDestiny.isPresent()) {

            var entity = optionalOrigin.get();
            var entityDestiny = optionalDestiny.get();

            var oldBalance = entity.getBalance();
            var oldBalanceDestiny = entityDestiny.getBalance();

            if (oldBalance.compareTo(amount) >= 0){
                entity.setBalance(oldBalance.subtract(amount));
                entity.setUpdated_at(LocalDateTime.now());
            }else {
                throw new BalanceToWithdrawException("insufficient balance to withdraw");
            }

            entityDestiny.setBalance(oldBalanceDestiny.add(amount));
            entityDestiny.setUpdated_at(LocalDateTime.now());

            accountRepository.save(entity);
            accountRepository.save(entityDestiny);

            sendMessageKafka(amount, entity, entityDestiny);
        }
    }

    private void sendMessageKafka(BigDecimal amount, AccountEntity entity, AccountEntity entityDestiny) {

        var entityDestinyKafka = TransactionRequest.builder()
                .agency(entityDestiny.getAgency())
                .number(entityDestiny.getNumber())
                .document(entityDestiny.getDocument())
                .dateTransfer(LocalDateTime.now())
                .transferValue(amount)
                .typeTransaction(ConstantsTypeTransaction.DEPOSIT)
                .build();

        var entityKafka = TransactionRequest.builder()
                .agency(entity.getAgency())
                .number(entity.getNumber())
                .document(entity.getDocument())
                .dateTransfer(LocalDateTime.now())
                .transferValue(amount)
                .typeTransaction(ConstantsTypeTransaction.TRANSFER)
                .accountDestiny(entityDestinyKafka)
                .build();

        sendMessage.execute(ConstantsKafka.TOPIC_TRANSFER_NAME, entityKafka);
        sendMessage.execute(ConstantsKafka.TOPIC_TRANSFER_NAME,entityDestinyKafka);
    }

}
