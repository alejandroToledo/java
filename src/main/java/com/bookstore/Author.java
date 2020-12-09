package com.bookstore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Nationality nationality;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author(){}
    public Author(String firstName,String lastName, Nationality nationality) {
        this.firstName= firstName;
        this.lastName= lastName;
        this.nationality= nationality;
    }

}
