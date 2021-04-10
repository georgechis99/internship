package com.arobs.library.model.mapper;

import com.arobs.library.model.dto.AuthorDTO;
import com.arobs.library.model.entity.Author;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AuthorMapper {
    AuthorDTO toDTO(Author author);
}
