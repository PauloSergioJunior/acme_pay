package br.com.acmePay.adapters.input.controller;

import br.com.acmePay.adapters.input.api.request.ITrustGateResourceAPI;
import br.com.acmePay.adapters.input.api.request.TrustGateRequest;
import br.com.acmePay.adapters.input.api.response.TrustGateResponse;
import br.com.acmePay.application.domain.TrustGateDomain;
import br.com.acmePay.application.domain.enums.StatusDocument;
import br.com.acmePay.application.ports.in.ICreateTrustGateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
public class TrustGateController implements ITrustGateResourceAPI {

    private ICreateTrustGateUseCase createTrustGate;

    @Override
    public TrustGateResponse create(TrustGateRequest request) {

        var trustGateDomain = TrustGateDomain.builder()
                .document(request.getDocument())
                .status_document(StatusDocument.SUSPENDED)
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .build();

        createTrustGate.execute(trustGateDomain);

        return TrustGateResponse.builder().message("Document Created").build();

    }

    @Override
    public List<TrustGateResponse> getTrustGates() {
        return List.of();
    }

}

