package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.implementation.AuthorModel;
import com.mjc.school.repository.model.implementation.NewsModel;
import com.mjc.school.repository.model.implementation.TagModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class NewsMapper {

    public NewsModel dtoRequestToModel(NewsDtoRequest dto) {
        List<TagModel> tags = dto.getTagIds().stream().map(id -> new TagModel(id, "")).toList();
        return new NewsModel(dto.getId(), dto.getTitle(), dto.getContent(), null, null, new AuthorModel(dto.getAuthorId(), "", null, null), tags);
    }

    public NewsDtoResponse modelToDtoResponse(NewsModel model) {
        List<Long> tagIds = model.getTag().stream().map(TagModel::getId).toList();
        return new NewsDtoResponse(model.getId(), model.getTitle(), model.getContent(), model.getCreateDate(), model.getLastUpdateDate(), model.getAuthor().getId(), tagIds);
    }

    public abstract List<NewsDtoResponse> listOfModelsToListOfResponses(List<NewsModel> modelList);
}
