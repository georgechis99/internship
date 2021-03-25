package com.arobs.library.model.mapper;

import com.arobs.library.model.Author;
import com.arobs.library.model.Book;
import com.arobs.library.repository.BookRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {

        Author author = new Author();
        author.setId(rs.getInt(BookRepository.COLUMN_AUTHOR_ID));
        author.setName(rs.getString(BookRepository.COLUMN_AUTHOR_NAME));

        return author;
    }
}