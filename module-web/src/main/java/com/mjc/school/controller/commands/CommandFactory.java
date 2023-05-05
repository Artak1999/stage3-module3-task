package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.implementation.AuthorController;
import com.mjc.school.controller.implementation.NewsController;
import com.mjc.school.controller.implementation.TagController;
import com.mjc.school.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CommandFactory {
    public static final int EXIT = 0;
    public static final int CREATE_NEWS = 1;
    public static final int GET_ALL_NEWS = 2;
    public static final int GET_NEWS_BY_ID = 3;
    public static final int UPDATE_NEWS = 4;
    public static final int DELETE_NEWS = 5;
    public static final int CREATE_AUTHOR = 6;
    public static final int GET_ALL_AUTHORS = 7;
    public static final int GET_AUTHOR_BY_ID = 8;
    public static final int UPDATE_AUTHOR = 9;
    public static final int DELETE_AUTHOR = 10;
    public static final int CREATE_TAG = 11;
    public static final int GET_ALL_TAGS = 12;
    public static final int GET_TAG_BY_ID = 13;
    public static final int UPDATE_TAG = 14;
    public static final int DELETE_TAG = 15;
    public static final int GET_AUTHOR_BY_NEWS_ID = 16;
    public static final int GET_TAGS_BY_NEWS_ID = 17;
    public static final int GET_NEWS_BY_TAG_NAMES = 18;
    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController;
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;
    private final BaseController<TagDtoRequest, TagDtoResponse, Long> tagController;

    public List<Integer> getAllCommands = Arrays.asList(CREATE_NEWS,GET_ALL_NEWS,GET_NEWS_BY_ID,UPDATE_NEWS,DELETE_NEWS,
                                            CREATE_AUTHOR,GET_ALL_AUTHORS, GET_AUTHOR_BY_ID,UPDATE_AUTHOR,DELETE_AUTHOR,
                                            CREATE_TAG,GET_ALL_TAGS,GET_TAG_BY_ID,UPDATE_TAG,DELETE_TAG,
                                            GET_AUTHOR_BY_NEWS_ID, GET_TAGS_BY_NEWS_ID,GET_NEWS_BY_TAG_NAMES);

    @Autowired
    public CommandFactory(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController,
                          BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController,
                          BaseController<TagDtoRequest, TagDtoResponse, Long> tagController) {
        this.newsController = newsController;
        this.authorController = authorController;
        this.tagController = tagController;
    }

    public Command create(int commandCode, Object... params) {
        return switch (commandCode) {
            case CREATE_NEWS -> new Create<>(newsController, new NewsDtoRequest(null, (String) params[0], (String) params[1], (Long) params[2]));
            case GET_ALL_NEWS -> new ReadAll<>(newsController);
            case GET_NEWS_BY_ID -> new GetById<>(newsController, (Long) params[0]);
            case UPDATE_NEWS -> new Update<>(newsController, new NewsDtoRequest((Long) params[0], (String) params[1], (String) params[2], (Long) params[3]));
            case DELETE_NEWS -> new Delete<>(newsController, (Long) params[0]);
            case CREATE_AUTHOR -> new Create<>(authorController, new AuthorDtoRequest(null, (String) params[0]));
            case GET_ALL_AUTHORS -> new ReadAll<>(authorController);
            case GET_AUTHOR_BY_ID -> new GetById<>(authorController, (Long) params[0]);
            case UPDATE_AUTHOR -> new Update<>(authorController, new AuthorDtoRequest((Long) params[0], (String) params[1]));
            case DELETE_AUTHOR -> new Delete<>(authorController, (Long) params[0]);
            case CREATE_TAG -> new Create<>(tagController, new TagDtoRequest(null, (String) params[0]));
            case GET_ALL_TAGS -> new ReadAll<>(tagController);
            case GET_TAG_BY_ID -> new GetById<>(tagController, (Long) params[0]);
            case UPDATE_TAG -> new Update<>(tagController, new TagDtoRequest((Long) params[0], (String) params[1]));
            case DELETE_TAG -> new Delete<>(tagController, (Long) params[0]);
            case GET_AUTHOR_BY_NEWS_ID -> new GetAuthorByNewsId((AuthorController) authorController,(Long) params[0]);
            case GET_TAGS_BY_NEWS_ID -> new GetTagsByNewsId((TagController) tagController,(Long) params[0]);
            case GET_NEWS_BY_TAG_NAMES -> new GetNewsByTagNames((NewsController) newsController,(List<String>) params[0],(List<Long>) params[1],(String) params[2],(String) params[3],(String) params[4]);
            default -> null;
        };
    }
}
