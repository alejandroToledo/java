package com.bookstore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Admin extends User {
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Admin(String email, String password, String firstname, String lastname, Store store){
        super(email, password, firstname, lastname);
        this.store = store;
    }
}
