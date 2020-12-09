package com.bookstore;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Storebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @OneToMany(mappedBy = "storebook", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Purchase> purchases;


    private int stock;

    public Storebook(){}

    public Storebook(Store store, Book book, int stock) {
        this.store = store;
        this.book = book;
        this.stock = stock;
    }

    public Book getBook() {
        return book;
    }

    public Store getStore() {
        return store;
    }

    public int getStock() {
        return stock;
    }

    public long getId() {
        return id;
    }

    public Map<String,Object> storebookDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("id",this.getId());
        dto.put("book", this.getBook());
        dto.put("stock", this.getStock());
        return dto;
    }
}
