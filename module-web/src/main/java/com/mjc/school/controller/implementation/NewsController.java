package com.mjc.school.controller.implementation;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NewsController implements BaseController<NewsDtoRequest, NewsDtoResponse, Long> {
    private final BaseService<NewsDtoRequest, NewsDtoResponse, Long> newsService;

    private NewsService newsServices;

    @Autowired
    public NewsController(BaseService<NewsDtoRequest, NewsDtoResponse, Long> newsService) {
        this.newsService = newsService;
    }

    @Override
    @CommandHandler(operation = 1)
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        return newsService.create(createRequest);
    }

    @Override
    @CommandHandler(operation = 4)
    public List readAll() {
        return newsService.readAll();
    }

    @Override
    @CommandHandler(operation = 7)
    public NewsDtoResponse readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    @CommandHandler(operation = 10)
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        return newsService.update(updateRequest);
    }

    @Override
    @CommandHandler(operation = 13)
    public boolean deleteById(Long id) {
        return newsService.deleteById(id);
    }

    @CommandHandler(operation = 18)
    public List<NewsDtoResponse> getNewsByCriteria(List<String> tagNames, List<Long> tagIds, String authorName,
                                                   String title, String content) {
        return newsServices.getNewsByCriteria(tagNames, tagIds, authorName, title, content);
    }
}
