package com.arobs.library.model.book.mapper;

import com.arobs.library.model.book.dto.BookDTO;
import com.arobs.library.model.book.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class BookMapper {

    @Mapping(target = "authorIds", expression = "java(getAuthorIds(book))")
    @Mapping(target = "tagIds", expression = "java(getTagIds(book))")
    @Mapping(target = "copyIds", expression = "java(getCopyIds(book))")
    public abstract BookDTO toDTO(Book book);

    public abstract Book toEntity(BookDTO bookDTO);

    @Mapping(target = "id", ignore = true)
    public abstract void merge(BookDTO bookDTO, @MappingTarget Book book);

    List<Integer> getAuthorIds(Book book) {
        return book.getAuthorIds();
    }

    List<Integer> getTagIds(Book book) {
        return book.getTagIds();
    }

    List<Integer> getCopyIds(Book book) {
        return book.getCopyIds();
    }
}
