package br.com.acmePay.adapters.output.repository;

import br.com.acmePay.adapters.output.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
