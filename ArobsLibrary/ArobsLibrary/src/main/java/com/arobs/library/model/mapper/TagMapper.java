package com.arobs.library.model.mapper;

import com.arobs.library.model.dto.TagDTO;
import com.arobs.library.model.entity.Tag;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDTO toDTO(Tag tag);
}
