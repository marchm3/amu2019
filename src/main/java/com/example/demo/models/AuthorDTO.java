package com.example.demo.models;

import java.util.List;

public class AuthorDTO {
    String fullname;
    String popularity;
    List<String> books;

    public AuthorDTO(String fullname, String popularity, List<String> books) {
        this.fullname = fullname;
        this.popularity = popularity;
        this.books = books;
    }

    public AuthorDTO() {}

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

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
