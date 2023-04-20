package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.implementation.TagModel;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target = "news", ignore = true)
    TagModel dtoRequestToModel(TagDtoRequest dto);

    TagDtoResponse modelToDtoResponse(TagModel model);

    List<TagDtoResponse> listOfModelsToListOfResponses(List<TagModel> modelList);
}
