package com.mjc.school.controller.implementation;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.CommandHandler;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController implements BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> {

    private final AuthorService authorServices;

    @Autowired
    public AuthorController(AuthorService authorServices) {
        this.authorServices = authorServices;
    }

    @Override
    @CommandHandler(operation = 2)
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        return authorServices.create(createRequest);
    }

    @Override
    @CommandHandler(operation = 5)
    public List<AuthorDtoResponse> readAll() {
        return authorServices.readAll();
    }

    @Override
    @CommandHandler(operation = 8)
    public AuthorDtoResponse readById(Long id) {
        return authorServices.readById(id);
    }

    @Override
    @CommandHandler(operation = 11)
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        return authorServices.update(updateRequest);
    }

    @Override
    @CommandHandler(operation = 14)
    public boolean deleteById(Long id) {
        return authorServices.deleteById(id);
    }

    @CommandHandler(operation = 16)
    public AuthorDtoResponse getAuthorByNewsId(Long id){
        return authorServices.getAuthorByNewsId(id);
    }
}
