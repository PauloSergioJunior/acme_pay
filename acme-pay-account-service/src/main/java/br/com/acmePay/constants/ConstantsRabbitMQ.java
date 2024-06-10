package br.com.acmePay.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ConstantsRabbitMQ {

     EXCHANGE_CHECK_DOCUMENT("check_document_queue_exchange"),
     EXCHANGE_CHECK_DOCUMENT_SUCCESS("check_document_queue_exchange_success"),
     EXCHANGE_CHECK_DOCUMENT_FAIL("check_document_queue_exchange_fail"),

     QUEUE_CHECK_DOCUMENT("queue_check_document"),
     QUEUE_SUCCESS_DOCUMENT("queue_success_document"),
     QUEUE_FAIL_DOCUMENT("queue_fail_document");

     private String value;

}
