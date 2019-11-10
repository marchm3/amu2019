package com.example.demo.services;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.BookDTO;
import com.example.demo.models.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {

    @Autowired
    AuthorsService authorsService;
    public HashMap<String, Book> books = new HashMap();

    public BookDTO createBook(BookDTO bookData) {
        List<Author> authors = bookData.getAuthors().stream().map(a ->
                this.authorsService.authors.get(a)).collect(Collectors.toList()
        );
        Book book = new Book(
                bookData.getTitle(),
                bookData.getCategory(),
                authors
        );
        authors.stream().forEach(a -> a.getBooks().add(book));
        books.put(bookData.getTitle(), book);
        return getBook(bookData.getTitle());
    }

    public BookDTO getBook(String title) {
        Book book = books.get(title);
        if(book == null) {
            throw new ResourceNotFoundException();
        }
        return new BookDTO(
                book.getTitle(),
                book.getCategory(),
                book.getAuthors().stream().map(a -> a.getFullname()).collect(Collectors.toList())
        );
    }

    public BookDTO updateBook(String title, BookDTO bookData) {
        deleteBook(title);
        return createBook(bookData);
    }

    public void deleteBook(String title) {
        Book book = books.get(title);
        book.getAuthors().forEach(a -> a.getBooks().remove(book));
        books.remove(title);
    }


}
