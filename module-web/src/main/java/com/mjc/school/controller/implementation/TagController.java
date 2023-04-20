package com.mjc.school.controller.implementation;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.CommandHandler;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;
import com.mjc.school.service.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TagController implements BaseController<TagDtoRequest, TagDtoResponse, Long> {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    @CommandHandler(operation = 3)
    public TagDtoResponse create(TagDtoRequest createRequest) {
        return tagService.create(createRequest);
    }

    @Override
    @CommandHandler(operation = 6)
    public List<TagDtoResponse> readAll() {
        return tagService.readAll();
    }

    @Override
    @CommandHandler(operation = 9)
    public TagDtoResponse readById(Long id) {
        return tagService.readById(id);
    }

    @Override
    @CommandHandler(operation = 12)
    public TagDtoResponse update(TagDtoRequest updateRequest) {
        return tagService.update(updateRequest);
    }

    @Override
    @CommandHandler(operation = 15)
    public boolean deleteById(Long id) {
        return tagService.deleteById(id);
    }

    @CommandHandler(operation = 17)
    public List<TagDtoResponse> getTagByNewsId(Long id) {
        return tagService.getTagsByNewsId(id);
    }
}
