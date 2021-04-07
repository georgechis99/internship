package com.arobs.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class ArobsLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArobsLibraryApplication.class, args);
    }

    @GetMapping("/startup/{name}")
    public String hello(@PathVariable("name") String name) {
        return String.format("Hello %s!", name);
    }

    //@PostMapping
//    @GetMapping("/showBooks")
//    public Book showBooks(@RequestParam(value = "bookId", defaultValue = "1") int bookId) {
//        List<Book> allBooks = BookManager.getBooks();
//        for (Book book : allBooks) {
//            if (book.getId() == bookId) {
//                return book;
//            }
//        }
//        return null;
//    }

    @GetMapping("/error2")
    public String error() {
        return "Error";
    }
}