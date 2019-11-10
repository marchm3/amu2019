package com.example.demo.controller;

import com.example.demo.models.AuthorDTO;
import com.example.demo.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("authors")
public class AuthorsController {

    @Autowired
    AuthorsService authorsService;

    @PostMapping()
    AuthorDTO createAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        return authorsService.createAuthor(authorDTO);
    }

    @GetMapping("{fullname}")
    AuthorDTO getAuthor(@PathVariable("fullname") String fullname ) {
        return authorsService.getAuthor(fullname);
    }

    @PutMapping("{fullname}")
    AuthorDTO updateAuthor(@RequestBody @Valid AuthorDTO authorDTO, @PathVariable("fullname") String fullname ) {
        return authorsService.updateAuthor(fullname, authorDTO);
    }

    @DeleteMapping
    void deleteAuthor(@PathVariable("fullname") String fullname ) {
        authorsService.deleteAuthor(fullname);
    }
}
