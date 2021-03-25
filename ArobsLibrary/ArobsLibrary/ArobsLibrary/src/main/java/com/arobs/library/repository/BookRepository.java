package com.arobs.library.repository;

import com.arobs.library.model.Author;
import com.arobs.library.model.Book;
import com.arobs.library.model.mapper.AuthorRowMapper;
import com.arobs.library.model.mapper.BookRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository implements BaseRepository<Book> {
    private static final Logger log = LoggerFactory.getLogger(BookRepository.class);

    public static final String TABLE_TAGS = "tag";
    public static final String COLUMN_TAG_ID = "id";
    public static final String COLUMN_TAG_NAME = "name";

    private static final String TABLE_AUTHORS = "author";
    public static final String COLUMN_AUTHOR_ID = "id";
    public static final String COLUMN_AUTHOR_NAME = "name";
    public static final String COLUMN_AUTHOR_DESCRIPTION = "description";

    private static final String TABLE_BOOKS = "book";
    public static final String COLUMN_BOOK_ID = "id";
    public static final String COLUMN_BOOK_AUTHOR_ID = "author_id";
    public static final String COLUMN_BOOK_TITLE = "title";
    public static final String COLUMN_BOOK_DESCRIPTION = "description";
    public static final String COLUMN_BOOK_ADDED_DATE = "addedDate";

    //SELECT

    private static final String SELECT_ALL_BOOKS = "SELECT * FROM " + TABLE_BOOKS;

    private static final String SELECT_ALL_BOOKS_ORDER_BY_TITLE_ASC = "SELECT * FROM " + TABLE_BOOKS +
            " ORDER BY " + COLUMN_BOOK_TITLE + " "; //ASC

    private static final String SELECT_ALL_BOOKS_ORDER_BY_TITLE_DESC = "SELECT * FROM " + TABLE_BOOKS +
            " ORDER BY " + COLUMN_BOOK_TITLE + " DESC";

    private static final String SELECT_ALL_BOOKS_ORDER_BY_ADDED_DATE_ASC = "SELECT * FROM " + TABLE_BOOKS +
            " ORDER BY " + COLUMN_BOOK_ADDED_DATE + " "; //ASC

    private static final String SELECT_ALL_BOOKS_ORDER_BY_ADDED_DATE_DESC = "SELECT * FROM " + TABLE_BOOKS +
            " ORDER BY " + COLUMN_BOOK_ADDED_DATE + " DESC";

    private static final String SELECT_BOOKS_BY_ID = "SELECT * FROM " + TABLE_BOOKS + " WHERE " + COLUMN_BOOK_ID + " = ?";

    private static final String SELECT_BOOKS_BY_AUTHOR_NAME = "SELECT * FROM " + TABLE_BOOKS +
            " INNER JOIN " + TABLE_AUTHORS +
            " ON " + TABLE_BOOKS + "." + COLUMN_BOOK_AUTHOR_ID + " = " + TABLE_AUTHORS + "." + COLUMN_AUTHOR_ID +
            " WHERE " + TABLE_AUTHORS + "." + COLUMN_AUTHOR_NAME + " = ?";

    private static final String SELECT_BOOKS_BY_TITLE = "SELECT * FROM " + TABLE_BOOKS +
            " WHERE " + COLUMN_BOOK_TITLE + " = ?";

    private static final String SELECT_AUTHORS_BY_NAME = "SELECT * FROM " + TABLE_AUTHORS +
            " WHERE " + COLUMN_AUTHOR_NAME + " = ?";

    //COUNT

    private static final String COUNT_ALL_BOOKS = "SELECT COUNT(*) FROM " + TABLE_BOOKS;

    //INSERT

    private static final String INSERT_BOOK = "INSERT INTO " + TABLE_BOOKS +
            "(" + COLUMN_BOOK_AUTHOR_ID + " , " + COLUMN_BOOK_TITLE + " , " + COLUMN_BOOK_ADDED_DATE +
            ") VALUES (? , ? , ?)";

    private static final String INSERT_AUTHOR = "INSERT INTO " + TABLE_AUTHORS +
            "(" + COLUMN_AUTHOR_NAME + ") VALUES (?)";

    //DELETE

    private static final String DELETE_BOOK_BY_TITLE = "DELETE FROM " + TABLE_BOOKS + " WHERE " + COLUMN_BOOK_TITLE + " = ?";

    //UPDATE

    private static final String UPDATE_BOOK_DESCRIPTION_BY_TITLE = "UPDATE " + TABLE_BOOKS +
            " SET " + COLUMN_BOOK_DESCRIPTION + " = ?" +
            " WHERE " + COLUMN_BOOK_TITLE + " = ?";

    private static final String UPDATE_AUTHOR_DESCRIPTION_BY_NAME = "UPDATE " + TABLE_AUTHORS +
            " SET " + COLUMN_AUTHOR_DESCRIPTION + " = ?" +
            " WHERE " + COLUMN_AUTHOR_NAME + " = ?";

    //Fields and Constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getById(int id) {
        return jdbcTemplate.queryForObject(
                SELECT_BOOKS_BY_ID,
                new BookRowMapper(),
                id
        );
    }

    @Override
    public Book getByTitle(String title) {
        log.info("getByTitle(" + title + ") BookRepository");
        return jdbcTemplate.queryForObject(
                SELECT_BOOKS_BY_TITLE,
                new BookRowMapper(),
                title
        );
    }

    public Author getAuthorByName(String name) {
        log.info("getAuthorByName(" + name + ") BookRepository");
        return jdbcTemplate.queryForObject(
                SELECT_AUTHORS_BY_NAME,
                new AuthorRowMapper(),
                name
        );
    }

    @Override
    public List<Book> getByAuthorName(String name) {
        return jdbcTemplate.query(
                SELECT_BOOKS_BY_AUTHOR_NAME,
                new BookRowMapper(),
                name
        );
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query(
                SELECT_ALL_BOOKS,
                new BookRowMapper());
    }

    @Override
    public List<Book> getAllOrderedByTitleAsc() {
        return jdbcTemplate.query(
                SELECT_ALL_BOOKS_ORDER_BY_TITLE_ASC,
                new BookRowMapper());
    }

    @Override
    public List<Book> getAllOrderedByTitleDesc() {
        return jdbcTemplate.query(
                SELECT_ALL_BOOKS_ORDER_BY_TITLE_DESC,
                new BookRowMapper());
    }

    @Override
    public List<Book> getAllOrderedByAddedDateAsc() {
        return jdbcTemplate.query(
                SELECT_ALL_BOOKS_ORDER_BY_ADDED_DATE_ASC,
                new BookRowMapper());
    }

    @Override
    public List<Book> getAllOrderedByAddedDateDesc() {
        return jdbcTemplate.query(
                SELECT_ALL_BOOKS_ORDER_BY_ADDED_DATE_DESC,
                new BookRowMapper());
    }

    @Override
    public Integer countAll() {
        return jdbcTemplate.queryForObject(
                COUNT_ALL_BOOKS,
                Integer.class
        );
    }

    @Override
    public int insert(int authorId, String title) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());
        return jdbcTemplate.update(
                INSERT_BOOK,
                authorId,
                title,
                currentDate
        );
    }

    //AUTO_GENERATED KEYS RETURNED (ID OF THE AUTHOR) FOR LATER BOOK_INSERT
    public int insertAuthor(String name){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public int deleteByTitle(String title) {
        return jdbcTemplate.update(
                DELETE_BOOK_BY_TITLE,
                title
        );
    }

    public int updateDescriptionByTitle(String newDescription, String title){
        return jdbcTemplate.update(
                UPDATE_BOOK_DESCRIPTION_BY_TITLE,
                newDescription,
                title
        );
    }

    public int updateAuthorDescriptionByName(String newDescription, String name){
        return jdbcTemplate.update(
                UPDATE_AUTHOR_DESCRIPTION_BY_NAME,
                newDescription,
                name
        );
    }
}
