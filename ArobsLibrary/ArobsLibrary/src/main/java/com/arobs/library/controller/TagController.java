package com.arobs.library.controller;

import com.arobs.library.model.dto.TagDTO;
import com.arobs.library.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/tags")
@RestController
@Validated
public class TagController {
    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable(value = "id") int id) {
        tagService.deleteById(id);
    }

    @GetMapping("/findAll")
    public List<TagDTO> findAllTags() {
        return tagService.findAll();
    }

    @PostMapping
    public TagDTO saveTag(@RequestBody TagDTO tagDTO) {
        return tagService.saveTag(tagDTO);
    }
}
