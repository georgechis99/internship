package com.arobs.library.controller;

import com.arobs.library.model.book.dto.BookDTO;
import com.arobs.library.model.book.dto.BookViewDTO;
import com.arobs.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;
import java.util.Set;

@RequestMapping(value = "/books")
@RestController
@Validated
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookDTO findBookById(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @GetMapping("/view/{id}")
    public BookViewDTO findViewBookById(@PathVariable("id") Integer id) {
        return bookService.findViewById(id);
    }

    @GetMapping("/findAll")
    public Set<BookDTO> findAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/viewFindAll")
    public Set<BookViewDTO> viewFindAllBooks() {
        return bookService.viewFindAll();
    }

    @GetMapping("/findByTags/{tagNames}")
    public Set<BookDTO> findBooksByTags(@RequestParam(value = "tagNames") String[] tagNames) {
        return bookService.findByTags(tagNames);
    }

    @GetMapping("/findByAuthors/{authorNames}")
    public Set<BookDTO> findBooksByAuthors(@RequestParam(value = "authorNames") String[] authorNames) {
        return bookService.findByAuthors(authorNames);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(value = "id") int id) {
        bookService.deleteById(id);
    }

    @PostMapping
    public BookDTO saveBook( @RequestBody BookDTO bookDTO) {
        Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
        bookDTO.setAddedDate(currentDate);
        return bookService.saveBook(bookDTO);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@RequestBody BookDTO bookDTO, @PathVariable(value = "id") int id) {
        Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
        bookDTO.setAddedDate(currentDate);
        bookDTO.setId(id);
        return bookService.updateBook(bookDTO);
    }

    @PutMapping("/{id}/addCopies/{numberOfCopies}")
    public BookDTO addCopies(@PathVariable(value = "id") int id,
                             @PathVariable(value = "numberOfCopies") int numberOfCopies) {
        return bookService.addCopies(id, numberOfCopies);
    }
}