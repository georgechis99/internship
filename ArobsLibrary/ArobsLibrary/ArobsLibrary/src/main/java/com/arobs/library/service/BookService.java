package com.arobs.library.service;

import com.arobs.library.model.Author;
import com.arobs.library.model.Book;
import com.arobs.library.repository.BookRepository;
import com.arobs.library.repository.BookRepositoryHibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private BookRepository bookRepository;
    private BookRepositoryHibernate bookRepositoryHibernate;

    @Autowired
    public BookService(BookRepository bookRepository,BookRepositoryHibernate bookRepositoryHibernate) {
        this.bookRepository = bookRepository;
        this.bookRepositoryHibernate = bookRepositoryHibernate;
    }

    public Book getById(int id) {
        Book book = bookRepositoryHibernate.getBookById(id);
        if (book != null) {
            return book;
        }
        log.info("No book found for id=" + id);
        throw new EmptyResultDataAccessException(1);
    }

    public Book getByTitle(String title) {
        Book book = bookRepository.getByTitle(title);
        if (book != null) {
            return book;
        }
        log.info("No book found for name = \"" + title + "\"");
        throw new EmptyResultDataAccessException(1);
    }

    public List<Book> getByAuthorName(String name) {
        List<Book> books = bookRepository.getByAuthorName(name);
        if (books != null) {
            return books;
        }
        log.info("No book found for author name = \"" + name + "\"");
        throw new IllegalStateException();
    }

    public List getAll() {
        List books = bookRepository.getAll();
        if (books != null) {
            return books;
        }
        log.info("No books found...");
        throw new IllegalStateException();
    }

    public List getAllOrderedByTitleAsc() {
        List books = bookRepository.getAllOrderedByTitleAsc();
        if (books != null) {
            return books;
        }
        log.info("No books found...");
        throw new IllegalStateException();
    }

    public List getAllOrderedByTitleDesc() {
        List books = bookRepository.getAllOrderedByTitleDesc();
        if (books != null) {
            return books;
        }
        log.info("No books found...");
        throw new IllegalStateException();
    }

    public List getAllOrderedByAddedDateAsc() {
        List books = bookRepository.getAllOrderedByAddedDateAsc();
        if (books != null) {
            return books;
        }
        log.info("No books found...");
        throw new IllegalStateException();
    }

    public List getAllOrderedByAddedDateDesc() {
        List books = bookRepository.getAllOrderedByAddedDateDesc();
        if (books != null) {
            return books;
        }
        log.info("No books found...");
        throw new IllegalStateException();
    }

    public int countAll() {
        Integer bookCount;
        bookCount = bookRepository.countAll();
        if (bookCount != null && bookCount != 0) {
            return bookCount;
        }
        log.info("No books found...");
        throw new IllegalStateException();
    }

    public int deleteByTitle(String title) {
        int affectedRows = bookRepository.deleteByTitle(title);
        if (affectedRows == 0) {
            throw new IllegalArgumentException();
        } else {
            return affectedRows;
        }
    }

    @Transactional
    public int insert(String title, String authorName) {
        try{
            Book foundBook = bookRepository.getByTitle(title);
            log.info("Book \"" + title + "\" was already in the system...");
            throw new IllegalStateException();
        } catch (EmptyResultDataAccessException e1){
            log.debug(e1.getMessage());
            try{
                Author foundAuthor = bookRepository.getAuthorByName(authorName);
                log.info("Author \"" + authorName + "\" was already in the system...");
                int authorId = foundAuthor.getId();
                log.info("Inserting book \"" + title + "\" by " + foundAuthor.getName());
                return bookRepository.insert(authorId, title);
            }catch (EmptyResultDataAccessException e2){
                log.info(e2.getMessage());
                //insert author get his id and then insert book
                int authorId = bookRepository.insertAuthor(authorName);
                log.info("Inserting book \"" + title + "\" by " + authorName);
                return bookRepository.insert(authorId, title);
            }
        }
    }

    public int updateDescriptionByTitle(String newDescription, String title){
        int affectedRows = bookRepository.updateDescriptionByTitle(newDescription,title);
        if (affectedRows == 0) {
            log.info("Update failed...");
            throw new IllegalArgumentException();
        } else {
            log.info("Update succeeded!");
            return affectedRows;
        }
    }

    public int updateAuthorDescriptionByName(String newDescription, String name){
        int affectedRows = bookRepository.updateAuthorDescriptionByName(newDescription,name);
        if (affectedRows == 0) {
            log.info("Update failed...");
            throw new IllegalArgumentException();
        } else {
            log.info("Update succeeded!");
            return affectedRows;
        }
    }
}
