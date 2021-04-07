package com.arobs.library.model.book.mapper;

import com.arobs.library.model.book.dto.AuthorDTO;
import com.arobs.library.model.book.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);
}
