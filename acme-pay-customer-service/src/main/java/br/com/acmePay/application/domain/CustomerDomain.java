package br.com.acmePay.application.domain;

import br.com.acmePay.application.domain.exception.CustomerDeleteException;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDomain {

    private Long id;
    private String customerDocument;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerPassword;

    private List<CustomerDomain> customers = new ArrayList<>();


    public CustomerDomain created(CustomerDomain customer){
        return null;
    }

    public List<CustomerDomain> listCustomer(){

        return this.customers.stream().toList();

    }

    public void deleteCustumer(String document) throws CustomerDeleteException {


        if (!valudDocument(document)){
            this.customers.remove(getByCustumerDocument(document));
        }else {
            throw new CustomerDeleteException("error delete");
        }
    }

    public CustomerDomain getByCustumerDocument(String document){

       return this.customers.stream()
               .filter(c -> c.getCustomerDocument().equals(document))
               .findFirst()
               .get();


    }

    private boolean valudEmail(String email){

        return this.customers.stream()
                .anyMatch(c -> c.getCustomerEmail().equals(email));

    }

    private boolean valudDocument(String document){

        return this.customers.stream()
                .anyMatch(c -> c.getCustomerDocument().equals(document));

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerDocument='" + customerDocument + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customers=" + customers.toString() +
                '}';
    }
}
