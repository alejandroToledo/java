package com.bookstore;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Storebook> storebookSet;

    public Book(){}
    public Book(String title,Author author, Category category) {
        this.title = title;
        this.author = author;
        this.category= category;
    }
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }

    public static void SearchByAuthor(){

    }
    public static void SellBook(){

    }
    public static void SearchByCategory(){

    }
    public Map<String,Object> bookDTO(){
        Map<String,Object> dto = new LinkedHashMap<>();
        dto.put("title", this.getTitle());
        dto.put("author", this.getAuthor());
        dto.put("category", this.getCategory());
        return dto;
    }
}
