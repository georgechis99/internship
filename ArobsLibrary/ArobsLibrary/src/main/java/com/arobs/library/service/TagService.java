package com.arobs.library.service;

import com.arobs.library.model.dto.TagDTO;
import com.arobs.library.model.entity.Tag;
import com.arobs.library.model.mapper.TagMapper;
import com.arobs.library.model.repository.TagRepository;
import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class TagService {

    private TagRepository tagRepository;
    private TagMapper tagMapper;

    @Autowired
    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Transactional
    public List<TagDTO> findAll() {
        List<Tag> tags = tagRepository.findAll();
        return toDTOList(tags);
    }

    @Transactional
    public void deleteById(int id){
        tagRepository.deleteById(id);
    }

    @Transactional
    public TagDTO saveTag(TagDTO tagDTO){
        if(isTagEnlisted(tagDTO.getName())){
            throw new DuplicateMappingException(DuplicateMappingException.Type.ENTITY, "for Tag");
        }
        Tag tag = new Tag();
        tag.setName(tagDTO.getName());
        return tagMapper.toDTO(tagRepository.save(tag));
    }

    private List<TagDTO> toDTOList(List<Tag> tags){
        List<TagDTO> dtoList = new ArrayList<>();
        for (Tag tag : tags) {
            dtoList.add(tagMapper.toDTO(tag));
        }
        return dtoList;
    }

    private boolean isTagEnlisted(String name) {
        return tagRepository.findByName(name) != null;
    }
}