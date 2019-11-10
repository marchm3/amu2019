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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public List<Book> getBooks() {
        return books;
    }
}
