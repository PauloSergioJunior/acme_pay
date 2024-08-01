package br.com.acmePay.application.domain;

import br.com.acmePay.application.ports.out.IListCustomer;
import br.com.acmePay.application.ports.out.ICreateCustomer;
import br.com.acmePay.application.ports.out.ISalary;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDomain {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private BigDecimal salary;


    public void create(ICreateCustomer createCustomer){
        createCustomer.execute(this);
    }

    public List<CustomerDomain> listCustomer(IListCustomer listCustomer){
        return listCustomer.execute();
    }

    public BigDecimal findWageByDocument(ISalary salary){

        return salary.execute(this.document);

    }

}