package com.example.demo.controller;

import com.example.demo.models.BookDTO;
import com.example.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @PostMapping()
    BookDTO createBook(@RequestBody @Valid BookDTO bookDTO) {
        return booksService.createBook(bookDTO);
    }

    @GetMapping("{title}")
    BookDTO getBook(@PathVariable("title") String title ) {
        return booksService.getBook(title);
    }

    @PutMapping("{title}")
    BookDTO updateBook(@RequestBody @Valid BookDTO bookDTO, @PathVariable("title") String title ) {
        return booksService.updateBook(title, bookDTO);
    }

    @DeleteMapping
    void deleteBook(@PathVariable("title") String title ) {
        booksService.deleteBook(title);
    }
}
