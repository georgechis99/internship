package com.arobs.library.model.book.mapper;

import com.arobs.library.model.book.entity.Book;
import com.arobs.library.model.book.dto.BookViewDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookViewMapper {

    BookViewDTO toViewDTO(Book book);

    Book toEntity(BookViewDTO bookViewDTO);
}
