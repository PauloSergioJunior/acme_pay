package br.com.acmePay.adapters.output.database.repository;

import br.com.acmePay.adapters.output.database.entity.TrustGateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITrustGateRepository extends JpaRepository<TrustGateEntity, Long> {

    Optional<TrustGateEntity> findByDocument(String document);

}
