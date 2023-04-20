package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.implementation.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "news", ignore = true)
    AuthorModel dtoRequestToModel(AuthorDtoRequest dto);

    AuthorDtoResponse modelToDtoResponse(AuthorModel model);

    List<AuthorDtoResponse> listOfModelsToListOfResponses(List<AuthorModel> modelList);
}
