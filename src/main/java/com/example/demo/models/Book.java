package com.example.demo.models;

import java.util.List;

public class Book {
    String title;
    String category;
    List<Author> authors;

    public Book(String title, String category, List<Author> authors) {
        this.title = title;
        this.category = category;
        this.authors = authors;
    }
}
