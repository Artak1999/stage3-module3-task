package com.mjc.school.service.interfaces;

import com.mjc.school.repository.model.implementation.NewsModel;
import com.mjc.school.service.dto.NewsDtoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T19:07:00+0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 20 (Oracle Corporation)"
)
public class NewsMapperImpl extends NewsMapper {

    @Override
    public List<NewsDtoResponse> listOfModelsToListOfResponses(List<NewsModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<NewsDtoResponse> list = new ArrayList<NewsDtoResponse>( modelList.size() );
        for ( NewsModel newsModel : modelList ) {
            list.add( modelToDtoResponse( newsModel ) );
        }

        return list;
    }
}
