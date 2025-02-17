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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
