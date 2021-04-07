package com.arobs.library.service;

import com.arobs.library.model.book.dto.BookDTO;
import com.arobs.library.model.book.dto.BookViewDTO;
import com.arobs.library.model.book.entity.Author;
import com.arobs.library.model.book.entity.Book;
import com.arobs.library.model.book.entity.Copy;
import com.arobs.library.model.book.entity.Tag;
import com.arobs.library.model.book.mapper.BookMapper;
import com.arobs.library.model.book.mapper.BookViewMapper;
import com.arobs.library.model.book.repository.AuthorRepository;
import com.arobs.library.model.book.repository.BookRepository;
import com.arobs.library.model.book.repository.CopyRepository;
import com.arobs.library.model.book.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Validated
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private TagRepository tagRepository;
    private CopyRepository copyRepository;
    private BookMapper bookMapper;
    private BookViewMapper bookViewMapper;

    @Autowired
    public BookService(BookRepository bookRepository, TagRepository tagRepository, AuthorRepository authorRepository,
                       CopyRepository copyRepository, BookMapper bookMapper, BookViewMapper bookViewMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.tagRepository = tagRepository;
        this.copyRepository = copyRepository;
        this.bookMapper = bookMapper;
        this.bookViewMapper = bookViewMapper;
    }

    @Transactional
    public BookDTO findById(int id) {
        Book foundBook = bookRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return bookMapper.toDTO(foundBook);
    }

    @Transactional
    public BookViewDTO findViewById(int id) {
        Book foundBook = bookRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return bookViewMapper.toViewDTO(foundBook);
    }

    @Transactional
    public Set<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        Set<BookDTO> bookDTOs = new HashSet<>();
        for (Book book : books) {
            bookDTOs.add(bookMapper.toDTO(book));
        }
        return bookDTOs;
    }

    @Transactional
    public Set<BookViewDTO> viewFindAll() {
        List<Book> books = bookRepository.findAll();
        Set<BookViewDTO> bookViewDTOs = new HashSet<>();
        for (Book book : books) {
            bookViewDTOs.add(bookViewMapper.toViewDTO(book));
        }
        return bookViewDTOs;
    }

    @Transactional
    public Set<BookDTO> findByTags(String[] tagNames) {
        Set<Tag> tags = retrieveTags(tagNames);
        return bookToDTOSet(bookRepository.findByTagsIn(tags));
    }

    private Set<BookDTO> bookToDTOSet(Set<Book> books){
        Set<BookDTO> bookDTOs = new HashSet<>();
        for (Book book : books) {
            bookDTOs.add(bookMapper.toDTO(book));
        }
        return bookDTOs;
    }

    private Set<Tag> retrieveTags(String[] tagNames){
        Set<Tag> tags = new HashSet<>();
        for (String tagName : tagNames) {
            Optional<Tag> foundTag = Optional.ofNullable(tagRepository.findByName(tagName));
            if (foundTag.isPresent()) {
                tags.add(foundTag.get());
            }
        }
        return tags;
    }

    @Transactional
    public Set<BookDTO> findByAuthors(String[] authorNames) {
        Set<Author> authors = retrieveAuthors(authorNames);
        return bookToDTOSet(bookRepository.findByAuthorsIn(authors));
    }

    private Set<Author> retrieveAuthors(String[] authorNames){
        Set<Author> authors = new HashSet<>();
        for (String authorName : authorNames) {
            Optional<Author> foundAuthor = Optional.ofNullable(authorRepository.findByName(authorName));
            if (foundAuthor.isPresent()) {
                authors.add(foundAuthor.get());
            }
        }
        return authors;
    }

    @Transactional
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        book = setEntityFields(bookDTO);
        return bookMapper.toDTO(bookRepository.save(book));
    }

    @Transactional
    public BookDTO updateBook(BookDTO bookDTO) {
        int id = bookDTO.getId();
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        foundBook = setEntityFields(bookDTO);
        bookRepository.save(foundBook);
        return bookMapper.toDTO(foundBook);
    }

    @Transactional
    public BookDTO addCopies(int id, int numberOfCopies) {
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        foundBook.addCopies(numberOfCopies);
        return bookMapper.toDTO(bookRepository.save(foundBook));
    }

    private Book setEntityFields(BookDTO bookDTO) {
        Book book = new Book();
        List<Integer> authorIds = bookDTO.getAuthorIds();
        List<Integer> tagIds = bookDTO.getTagIds();
        List<Integer> copyIds = bookDTO.getCopyIds();
        book.setAddedDate(bookDTO.getAddedDate());
        book.setAuthors(getAuthors(authorIds));
        book.setTags(getTags(tagIds));
        book.setCopies(getCopies(copyIds));
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        return book;
    }

    private Set<Author> getAuthors(List<Integer> authorIds) {
        Set<Author> authors = new HashSet<>();
        for (Integer i : authorIds) {
            authors.add(authorRepository.findById(i).orElseThrow(IllegalArgumentException::new));
        }
        return authors;
    }

    private Set<Tag> getTags(List<Integer> tagIds) {
        Set<Tag> tags = new HashSet<>();
        for (Integer i : tagIds) {
            tags.add(tagRepository.findById(i).orElseThrow(IllegalArgumentException::new));
        }
        return tags;
    }

    private Set<Copy> getCopies(List<Integer> copyIds) {
        Set<Copy> copies = new HashSet<>();
        for (Integer i : copyIds) {
            copies.add(copyRepository.findById(i).orElseThrow(IllegalArgumentException::new));
        }
        return copies;
    }
}
