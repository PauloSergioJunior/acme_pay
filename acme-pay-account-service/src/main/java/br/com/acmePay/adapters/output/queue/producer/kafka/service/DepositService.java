package br.com.acmePay.adapters.output.queue.producer.kafka.service;

import br.com.acmePay.adapters.output.database.repository.IAccountRepository;
import br.com.acmePay.adapters.output.queue.dto.KafkaDTO;
import br.com.acmePay.adapters.output.queue.dto.Transaction;
import br.com.acmePay.adapters.output.queue.producer.kafka.ISendMessage;
import br.com.acmePay.application.domain.AccountDomain;
import br.com.acmePay.application.ports.out.IDeposit;
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
public class DepositService implements IDeposit {

    private final IAccountRepository accountRepository;
    private final ISendMessage sendMessage;

    @Override
    public void execute(AccountDomain domain, BigDecimal amount) {

        var optional = accountRepository
                .findByDocumentAndNumberAndAgency(domain.getDocument(),
                                                    domain.getNumber(),
                                                    domain.getAgency());

        if (optional.isPresent()) {

           var entity = optional.get();

           var oldBalance = entity.getBalance();
           entity.setBalance(amount.add(oldBalance));
           entity.setUpdated_at(LocalDateTime.now());

           accountRepository.save(entity);

           sendMessageKafka(amount, domain);
        }
    }

    private void sendMessageKafka(BigDecimal amount, AccountDomain accountOrigin) {

        var dtoOrigin = KafkaDTO.builder()
                .agency(accountOrigin.getAgency())
                .number(accountOrigin.getNumber())
                .document(accountOrigin.getDocument()).build();

        var entityKafka = Transaction.builder()
                .accountDestiny(null)
                .accountOrigin(dtoOrigin)
                .typeTransaction(ConstantsTypeTransaction.DEPOSIT)
                .dateTransfer(DateFormat.format())
                .transferValue(amount)
                .build();

        sendMessage.execute(ConstantsKafka.TOPIC_TRANSFER_NAME, entityKafka);
    }


}
