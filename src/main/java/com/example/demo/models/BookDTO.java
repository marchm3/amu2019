package com.example.demo.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class BookDTO {
    @NotEmpty(message = "Please provide a title")
    String title;

    @NotEmpty(message = "Please provide a category")
    String category;

    @Size(min=1)
    List<String> authors;

    public BookDTO(String title, String category, List<String> authors) {
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
