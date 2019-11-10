package com.example.demo.models;

import java.util.List;

public class Author {
    String fullname;
    String popularity;
    List<Book> books;

    public Author(String fullname, String popularity, List<Book> books) {
        this.fullname = fullname;
        this.popularity = popularity;
        this.books = books;
    }
}
