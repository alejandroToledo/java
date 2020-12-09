package com.bookstore;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Purchase> purchases;
    
    public  Customer(){}
    public Customer(String email, String password, String firstName, String lastName){
        super(email, password, firstName, lastName);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public long getId() {
        return id;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }


    public Map<String,Object> customerDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("email", this.getEmail());
        dto.put("password", this.getPassword());
        return dto;
    }
}
