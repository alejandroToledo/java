package com.bookstore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books;

    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Storebook> storebookSet;

    public Store() {}
    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }
    public Map<String,Object> storeDto(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("name", this.getName());
        dto.put("address", this.getAddress());
        return dto;
    }
}
