package br.com.acmePay.adapters.output.database.repository;

import br.com.acmePay.adapters.output.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByDocument(String document);
}
