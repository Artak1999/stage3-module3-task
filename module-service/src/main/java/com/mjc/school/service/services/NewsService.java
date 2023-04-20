package com.mjc.school.service.services;

import com.mjc.school.repository.model.implementation.NewsModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import java.util.List;



public interface NewsService extends BaseService<NewsDtoRequest, NewsDtoResponse, Long> {
    List<NewsDtoResponse> getNewsByCriteria(List<String> tagNames, List<Long> tagIds, String authorName, String title, String content);

    NewsModel dtoRequestToModel(NewsDtoRequest dto);

    NewsDtoResponse modelToDtoResponse(NewsModel model);
}