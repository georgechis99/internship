package com.arobs.library.service;

import com.arobs.library.model.dto.BookDTO;
import com.arobs.library.model.dto.BookViewDTO;
import com.arobs.library.model.entity.Author;
import com.arobs.library.model.entity.Book;
import com.arobs.library.model.entity.Copy;
import com.arobs.library.model.entity.Tag;
import com.arobs.library.model.mapper.BookMapper;
import com.arobs.library.model.mapper.BookViewMapper;
import com.arobs.library.model.repository.AuthorRepository;
import com.arobs.library.model.repository.BookRepository;
import com.arobs.library.model.repository.CopyRepository;
import com.arobs.library.model.repository.TagRepository;
import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.*;

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
    public List<BookDTO> findAll() {
        List<Book> books = bookRepository.findAll();
        return toDTOList(books);
    }

    @Transactional
    public List<BookViewDTO> viewFindAll() {
        List<Book> books = bookRepository.findAll();
        return toViewDTOList(books);
    }

    @Transactional
    public List<BookDTO> findByTags(String[] tagNames) {
        Set<Tag> tags = retrieveTags(tagNames);
        return toDTOList(bookRepository.findByTagsIn(tags));
    }

    @Transactional
    public List<BookDTO> findByAuthors(String[] authorNames) {
        Set<Author> authors = retrieveAuthors(authorNames);
        return toDTOList(bookRepository.findByAuthorsIn(authors));
    }

    @Transactional
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public BookDTO saveBook(BookDTO bookDTO) {
        if (isBookEnlisted(bookDTO.getTitle())) {
            throw new DuplicateMappingException(DuplicateMappingException.Type.ENTITY, "for Book");
        }
        Book book = bookMapper.toEntity(bookDTO);
        setEntityFields(book, bookDTO);
        return bookMapper.toDTO(bookRepository.save(book));
    }

    @Transactional
    public BookDTO updateBook(BookDTO bookDTO) {
        int id = bookDTO.getId();
        Book foundBook = bookRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        setEntityFields(foundBook, bookDTO);
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

    private boolean isBookEnlisted(String title) {
        return bookRepository.findByTitle(title) != null;
    }

    private List<BookDTO> toDTOList(List<Book> books) {
        List<BookDTO> dtoList = new ArrayList<>();
        for (Book book : books) {
            dtoList.add(bookMapper.toDTO(book));
        }
        return dtoList;
    }

    private List<BookViewDTO> toViewDTOList(List<Book> books) {
        List<BookViewDTO> viewDtoList = new ArrayList<>();
        for (Book book : books) {
            viewDtoList.add(bookViewMapper.toViewDTO(book));
        }
        return viewDtoList;
    }

    private Set<Tag> retrieveTags(String[] tagNames) {
        Set<Tag> tags = new HashSet<>();
        for (String tagName : tagNames) {
            Optional<Tag> foundTag = Optional.ofNullable(tagRepository.findByName(tagName));
            if (foundTag.isPresent()) {
                tags.add(foundTag.get());
            }
        }
        return tags;
    }

    private Set<Author> retrieveAuthors(String[] authorNames) {
        Set<Author> authors = new HashSet<>();
        for (String authorName : authorNames) {
            Optional<Author> foundAuthor = Optional.ofNullable(authorRepository.findByName(authorName));
            if (foundAuthor.isPresent()) {
                authors.add(foundAuthor.get());
            }
        }
        return authors;
    }

    private void setEntityFields(Book book, BookDTO bookDTO) {
        book.setAuthors(getAuthorsFromIds(bookDTO.getAuthorIds()));
        book.setTags(getTagsFromIds(bookDTO.getTagIds()));
        book.setCopies(getCopiesFromIds(bookDTO.getCopyIds()));

        book.setAddedDate(bookDTO.getAddedDate());
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
    }

    private Set<Author> getAuthorsFromIds(List<Integer> authorIds) {
        Set<Author> authors = new HashSet<>();
        for (Integer i : authorIds) {
            authors.add(authorRepository.findById(i).orElseThrow(IllegalArgumentException::new));
        }
        return authors;
    }

    private Set<Tag> getTagsFromIds(List<Integer> tagIds) {
        Set<Tag> tags = new HashSet<>();
        for (Integer i : tagIds) {
            tags.add(tagRepository.findById(i).orElseThrow(IllegalArgumentException::new));
        }
        return tags;
    }

    private Set<Copy> getCopiesFromIds(List<Integer> copyIds) {
        Set<Copy> copies = new HashSet<>();
        for (Integer i : copyIds) {
            copies.add(copyRepository.findById(i).orElseThrow(IllegalArgumentException::new));
        }
        return copies;
    }
}
