package com.arobs.library.model.mapper;

import com.arobs.library.model.dto.BookRentDTO;
import com.arobs.library.model.entity.BookRent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class BookRentMapper {

    @Mapping(target = "employeeId", expression = "java(getEmployeeId(bookRent))")
    @Mapping(target = "bookId", expression = "java(getBookId(bookRent))")
    @Mapping(target = "copyId", expression = "java(getCopyId(bookRent))")
    public abstract BookRentDTO toDTO(BookRent bookRent);

    public abstract BookRent toEntity(BookRentDTO bookRentDTO);

    int getEmployeeId(BookRent bookRent){
        return bookRent.getEmployeeId();
    }

    int getBookId(BookRent bookRent){
        return bookRent.getBookId();
    }

    int getCopyId(BookRent bookRent){
        return bookRent.getCopyId();
    }
}
