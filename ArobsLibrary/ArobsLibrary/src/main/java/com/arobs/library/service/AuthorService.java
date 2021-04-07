package com.arobs.library.service;

import com.arobs.library.model.book.dto.AuthorDTO;
import com.arobs.library.model.book.dto.BookDTO;
import com.arobs.library.model.book.entity.Author;
import com.arobs.library.model.book.entity.Book;
import com.arobs.library.model.book.mapper.AuthorMapper;
import com.arobs.library.model.book.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Validated
public class AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Transactional
    public Set<AuthorDTO> findAll() {
        List<Author> authors = authorRepository.findAll();
        Set<AuthorDTO> authorDTOs = new HashSet<>();
        for (Author author : authors) {
            authorDTOs.add(authorMapper.toDTO(author));
        }
        return authorDTOs;
    }

    @Transactional
    public void deleteById(int id){
        authorRepository.deleteById(id);
    }

    @Transactional
    public AuthorDTO saveAuthor(AuthorDTO authorDTO){
        Author author = new Author();
        author.setName(authorDTO.getName());
//        author.setBooks(new HashSet<>());
        return authorMapper.toDTO(authorRepository.save(author));
    }
}
