package com.mjc.school.service.services;

import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;


public interface AuthorService extends BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> {
    AuthorDtoResponse getAuthorByNewsId(Long id);
}
