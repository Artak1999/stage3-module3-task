package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.implementation.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T21:32:22+0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 17.0.6 (JetBrains s.r.o.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorModel dtoRequestToModel(AuthorDtoRequest dto) {
        if ( dto == null ) {
            return null;
        }

        AuthorModel authorModel = new AuthorModel();

        authorModel.setId( dto.getId() );
        authorModel.setName( dto.getName() );

        return authorModel;
    }

    @Override
    public AuthorDtoResponse modelToDtoResponse(AuthorModel model) {
        if ( model == null ) {
            return null;
        }

        AuthorDtoResponse authorDtoResponse = new AuthorDtoResponse();

        authorDtoResponse.setId( model.getId() );
        authorDtoResponse.setName( model.getName() );
        authorDtoResponse.setLastUpdateDate( model.getLastUpdateDate() );

        return authorDtoResponse;
    }

    @Override
    public List<AuthorDtoResponse> listOfModelsToListOfResponses(List<AuthorModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<AuthorDtoResponse> list = new ArrayList<AuthorDtoResponse>( modelList.size() );
        for ( AuthorModel authorModel : modelList ) {
            list.add( modelToDtoResponse( authorModel ) );
        }

        return list;
    }
}
