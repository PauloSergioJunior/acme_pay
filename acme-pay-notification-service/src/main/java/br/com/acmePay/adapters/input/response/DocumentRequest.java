package br.com.acmePay.adapters.input.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class DocumentRequest implements Serializable {
    private String document;
}
