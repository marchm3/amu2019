package com.example.demo.services;

import com.example.demo.models.Author;
import com.example.demo.models.AuthorDTO;
import com.example.demo.models.Book;
import com.example.demo.models.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    @Autowired
    BooksService booksService;
    public HashMap<String, Author> authors = new HashMap<>();

    public AuthorDTO createAuthor(AuthorDTO authorData) {
        List<Book> books = authorData.getBooks().stream().map(a ->
                this.booksService.books.get(a)).collect(Collectors.toList()
        );
        Author author = new Author(
                authorData.getFullname(),
                authorData.getPopularity(),
                books
        );
        books.stream().forEach(a -> a.getAuthors().add(author));
        authors.put(authorData.getFullname(), author);
        return getAuthor(authorData.getFullname());
    }

    public AuthorDTO getAuthor(String fullname) {
        Author author = authors.get(fullname);
        if(author == null) {
            throw new ResourceNotFoundException();
        }
        return new AuthorDTO(
                author.getFullname(),
                author.getPopularity(),
                author.getBooks().stream().map(a -> a.getTitle()).collect(Collectors.toList())
        );
    }

    public AuthorDTO updateAuthor(String title, AuthorDTO authorData) {
        deleteAuthor(title);
        return createAuthor(authorData);
    }

    public void deleteAuthor(String fullname) {
        Author author = authors.get(fullname);
        author.getBooks().forEach(a -> a.getAuthors().remove(author));
        authors.remove(fullname);
    }
}
