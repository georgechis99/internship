package com.arobs.library.controller;

import com.arobs.library.exception.InvalidInputException;
import com.arobs.library.model.dto.BookDTO;
import com.arobs.library.model.dto.BookRentDTO;
import com.arobs.library.service.BookRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RequestMapping(value = "/bookRents")
@RestController
@Validated
public class BookRentController {

    private BookRentService bookRentService;

    @Autowired
    public BookRentController(BookRentService bookRentService) {
        this.bookRentService = bookRentService;
    }

    @GetMapping("/findAll")
    public List<BookRentDTO> findAllBooks() {
        return bookRentService.findAll();
    }

    @PutMapping("markAsLate/{id}")
    public BookRentDTO markAsLate(@RequestBody BookRentDTO bookRentDTO, @PathVariable(value = "id") int id) {
        bookRentDTO.setId(id);
        return bookRentService.markAsLate(bookRentDTO);
    }

    @PostMapping("/{employeeId}/{bookId}")
    public BookRentDTO rentBook(@PathVariable(value = "employeeId") int employeeId,
                                @PathVariable(value = "bookId") int bookId) {
        return bookRentService.rentBook(employeeId, bookId);
    }

    @PutMapping("/{bookRentId}")
    public BookRentDTO returnBook(@PathVariable(value = "bookRentId") int bookRentId,
                                  @RequestParam(value = "rating") @Min(1) @Max(5) @NotNull Integer rating,
                                  @RequestParam(value = "noteAtReturn") @Size(max = 500) String noteAtReturn) {
        return bookRentService.returnBook(bookRentId, rating, noteAtReturn);
    }
}
