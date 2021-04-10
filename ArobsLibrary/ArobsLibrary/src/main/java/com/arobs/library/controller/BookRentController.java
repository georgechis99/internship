package com.arobs.library.controller;

import com.arobs.library.model.dto.BookRentDTO;
import com.arobs.library.service.BookRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public List<BookRentDTO> findAllBookRents() {
        return bookRentService.findAll();
    }

//    @PutMapping("markAsLate/{id}")
//    public BookRentDTO markAsLate(@PathVariable(value = "id") int bookRentId) {
//        return bookRentService.markAsLate(bookRentId);
//    }

    @PutMapping("/systemCheckForLateBookRents")
    public void systemCheckForLateBookRents(){
        bookRentService.systemCheckForLateBookRents();
    }

    @PostMapping("/rent")
    public BookRentDTO rentBook(@RequestParam(value = "employeeId") int employeeId,
                                @RequestParam(value = "bookId") int bookId) {
        return bookRentService.rentBook(employeeId, bookId);
    }

    @PutMapping("/return/{bookRentId}")
    public BookRentDTO returnBook(@PathVariable(value = "bookRentId") int bookRentId,
                                  @RequestParam(value = "rating") @Min(1) @Max(5) @NotNull Integer rating,
                                  @RequestParam(value = "noteAtReturn") @Size(max = 500) String noteAtReturn) {
        return bookRentService.returnBook(bookRentId, rating, noteAtReturn);
    }

    @PutMapping("/extend/{bookRentId}")
    public BookRentDTO extendRental(@PathVariable(value = "bookRentId") int bookRentId) {
        return bookRentService.extendRental(bookRentId);
    }
}
