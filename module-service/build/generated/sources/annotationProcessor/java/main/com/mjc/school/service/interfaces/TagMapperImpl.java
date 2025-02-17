package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.implementation.TagModel;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-30T15:00:26+0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.6 (JetBrains s.r.o.)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagModel dtoRequestToModel(TagDtoRequest dto) {
        if ( dto == null ) {
            return null;
        }

        TagModel tagModel = new TagModel();

        tagModel.setId( dto.getId() );
        tagModel.setName( dto.getName() );

        return tagModel;
    }

    @Override
    public TagDtoResponse modelToDtoResponse(TagModel model) {
        if ( model == null ) {
            return null;
        }

        TagDtoResponse tagDtoResponse = new TagDtoResponse();

        tagDtoResponse.setId( model.getId() );
        tagDtoResponse.setName( model.getName() );

        return tagDtoResponse;
    }

    @Override
    public List<TagDtoResponse> listOfModelsToListOfResponses(List<TagModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<TagDtoResponse> list = new ArrayList<TagDtoResponse>( modelList.size() );
        for ( TagModel tagModel : modelList ) {
            list.add( modelToDtoResponse( tagModel ) );
        }

        return list;
    }
}
