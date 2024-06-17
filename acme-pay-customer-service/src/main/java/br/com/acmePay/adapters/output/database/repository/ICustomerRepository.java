package br.com.acmePay.adapters.output.database.repository;

import br.com.acmePay.adapters.output.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
