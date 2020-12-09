package com.bookstore;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "storebook_id")
    private Storebook storebook;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Purchase(){ }
    public Purchase( Storebook storebook,  Customer customer){
        this.storebook = storebook;
        this.customer = customer;
    }

    public void setStorebook(Storebook storebook) {
        this.storebook = storebook;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Storebook getStorebook() {
        return storebook;
    }

    public long getId() {
        return id;
    }
    public Map<String,Object> purchaseDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",this.getId());
        dto.put("book", this.getStorebook().getBook().bookDTO());
        return dto;
    }
}
