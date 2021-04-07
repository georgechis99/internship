package com.arobs.library.controller;

import com.arobs.library.model.book.dto.AuthorDTO;
import com.arobs.library.model.book.dto.BookDTO;
import com.arobs.library.model.book.entity.Author;
import com.arobs.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequestMapping(value = "/authors")
@RestController
@Validated
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable(value = "id") int id) {
        authorService.deleteById(id);
    }

    @GetMapping("/findAll")
    public Set<AuthorDTO> findAllAuthors() {
        return authorService.findAll();
    }

    @PostMapping
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.saveAuthor(authorDTO);
    }
}
