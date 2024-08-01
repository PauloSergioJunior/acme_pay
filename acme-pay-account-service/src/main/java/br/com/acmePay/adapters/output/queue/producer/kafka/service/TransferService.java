package br.com.acmePay.adapters.output.queue.producer.kafka.service;

import br.com.acmePay.adapters.output.database.repository.IAccountRepository;
import br.com.acmePay.adapters.output.queue.dto.KafkaDTO;
import br.com.acmePay.adapters.output.queue.dto.Transaction;
import br.com.acmePay.adapters.output.queue.producer.kafka.ISendMessage;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmePay.application.ports.out.IDeposit;
import br.com.acmePay.application.ports.out.ITransfer;
import br.com.acmePay.application.utils.DateFormat;
import br.com.acmePay.constants.ConstantsKafka;
import br.com.acmePay.constants.ConstantsTypeTransaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class TransferService implements ITransfer {

    private final IAccountRepository accountRepository;
    private final ISendMessage sendMessage;
    private final IDeposit deposit;

    @Override
    public void execute(AccountDomain accountOrigin, AccountDomain accountDestiny, BigDecimal amount) throws BalanceToWithdrawException {


        var optionalOrigin = accountRepository
                .findByDocumentAndNumberAndAgency(accountOrigin.getDocument(),
                                                    accountOrigin.getNumber(),
                                                    accountOrigin.getAgency());


        if (optionalOrigin.isPresent() ) {

            var entity = optionalOrigin.get();

            var oldBalance = entity.getBalance();

            if (oldBalance.compareTo(amount) >= 0){
                entity.setBalance(oldBalance.subtract(amount));
                entity.setUpdated_at(LocalDateTime.now());
            }else {
                throw new BalanceToWithdrawException("insufficient balance to withdraw");
            }


            accountRepository.save(entity);

            sendMessageKafka(amount, accountOrigin, accountDestiny);
            deposit.execute(accountDestiny, amount);
        }
    }

    private void sendMessageKafka(BigDecimal amount, AccountDomain accountOrigin, AccountDomain accountDestiny) {

        var dtoOrigin = KafkaDTO.builder()
                .agency(accountOrigin.getAgency())
                .number(accountOrigin.getNumber())
                .document(accountOrigin.getDocument()).build();

        var dtoDestiny = KafkaDTO.builder()
                .agency(accountDestiny.getAgency())
                .number(accountDestiny.getNumber())
                .document(accountDestiny.getDocument()).build();

        var entityKafka = Transaction.builder()
                        .accountDestiny(dtoDestiny)
                        .accountOrigin(dtoOrigin)
                        .typeTransaction(ConstantsTypeTransaction.TRANSFER)
                        .dateTransfer(DateFormat.format())
                        .transferValue(amount)
                .build();


        sendMessage.execute(ConstantsKafka.TOPIC_TRANSFER_NAME, entityKafka);
    }

}
