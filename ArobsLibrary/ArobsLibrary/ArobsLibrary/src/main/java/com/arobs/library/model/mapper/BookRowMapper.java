package com.arobs.library.model.mapper;

import com.arobs.library.model.Book;
import com.arobs.library.repository.BookRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Book book = new Book();
        book.setId(rs.getInt(BookRepository.COLUMN_BOOK_ID));
        book.setTitle(rs.getString(BookRepository.COLUMN_BOOK_TITLE));
        book.setDescription(rs.getString(BookRepository.COLUMN_BOOK_DESCRIPTION));
//        book.setAdded_date(rs.getDate(BookRepository.COLUMN_BOOK_ADDED_DATE));

        return book;
    }
}