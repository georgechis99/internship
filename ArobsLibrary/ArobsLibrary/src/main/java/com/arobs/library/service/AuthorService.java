package com.arobs.library.service;

import com.arobs.library.model.dto.AuthorDTO;
import com.arobs.library.model.entity.Author;
import com.arobs.library.model.mapper.AuthorMapper;
import com.arobs.library.model.repository.AuthorRepository;
import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

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
    public List<AuthorDTO> findAll() {
        List<Author> authors = authorRepository.findAll();
        return toDTOList(authors);
    }

    @Transactional
    public void deleteById(int id){
        authorRepository.deleteById(id);
    }

    @Transactional
    public AuthorDTO saveAuthor(AuthorDTO authorDTO){
        if(isAuthorEnlisted(authorDTO.getName())){
            throw new DuplicateMappingException(DuplicateMappingException.Type.ENTITY, "for Author");
        }
        Author author = new Author();
        author.setName(authorDTO.getName());
        return authorMapper.toDTO(authorRepository.save(author));
    }

    private boolean isAuthorEnlisted(String name) {
        return authorRepository.findByName(name) != null;
    }

    private List<AuthorDTO> toDTOList(List<Author> authors){
        List<AuthorDTO> dtoList = new ArrayList<>();
        for (Author author : authors) {
            dtoList.add(authorMapper.toDTO(author));
        }
        return dtoList;
    }
}
