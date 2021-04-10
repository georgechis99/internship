package com.arobs.library.model.mapper;

import com.arobs.library.model.entity.Book;
import com.arobs.library.model.dto.BookViewDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookViewMapper {
    BookViewDTO toViewDTO(Book book);
}
