package com.arobs.library.controller;

import com.arobs.library.model.Book;
import com.arobs.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/books")
@RestController
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") int id) {
        log.info("Getting book where book.id=" + id);
        return bookService.getById(id);
    }

    @GetMapping("/title")
    public Book getByTitle(@RequestParam(value = "value") String title) {
        log.info("Getting book where book.title = \"" + title + "\"");
        return bookService.getByTitle(title);
    }

    @GetMapping("/authorName")
    public List<Book> getByAuthorName(@RequestParam(value = "value") String name) {
        log.info("Getting books where author name = \"" + name + "\"");
        return bookService.getByAuthorName(name);
    }

    @GetMapping("/getAll")
    public List getAllBooks() {
        log.info("Getting all books");
        return bookService.getAll();
    }

    @GetMapping("/getAllOrderedByTitleAsc")
    public List getAllOrderedByTitleAsc() {
        log.info("Getting all books ordered by book.title asc");
        return bookService.getAllOrderedByTitleAsc();
    }

    @GetMapping("/getAllOrderedByTitleDesc")
    public List getAllOrderedByTitleDesc() {
        log.info("Getting all books ordered by book.title desc");
        return bookService.getAllOrderedByTitleDesc();
    }

    @GetMapping("/getAllOrderedByAddedDateAsc")
    public List getAllOrderedByAddedDateAsc() {
        log.info("Getting all books ordered by book.addedDate asc");
        return bookService.getAllOrderedByAddedDateAsc();
    }

    @GetMapping("/getAllOrderedByAddedDateDesc")
    public List getAllOrderedByAddedDateDesc() {
        log.info("Getting all books ordered by book.addedDate desc");
        return bookService.getAllOrderedByAddedDateDesc();
    }

    @GetMapping("/countAll")
    public int countAll() {
        log.info("Getting the number of all total books available");
        return bookService.countAll();
    }

    @DeleteMapping("/delete")
    public int deleteByTitle(@RequestParam(value = "title") String title) {
        log.info("Deleting book where title = " + title);
        return bookService.deleteByTitle(title);
    }

    @PostMapping("/insert")
    public int insertBook(@RequestParam(value = "title") String title, @RequestParam(value = "author") String authorname) {
        log.info("Inserting book where title = " + title + " , author = " + authorname);
        return bookService.insert(title, authorname);
    }

    @PutMapping("/updateDescription")
    public int updateDescriptionByTitle(@RequestParam(value = "newDescription") String newDescription, @RequestParam(value = "title") String title) {
        log.info("Updating description with \"" + newDescription + "\" for book with title = " + title);
        return bookService.updateDescriptionByTitle(newDescription, title);
    }

    @PutMapping("/updateAuthorDescription")
    public int updateAuthorDescriptionByName(@RequestParam(value = "newDescription") String newDescription, @RequestParam(value = "name") String name) {
        log.info("Updating description with \"" + newDescription + "\" for author with name = " + name);
        return bookService.updateAuthorDescriptionByName(newDescription, name);
    }
}