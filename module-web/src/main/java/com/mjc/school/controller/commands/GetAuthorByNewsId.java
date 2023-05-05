package com.mjc.school.controller.commands;

import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.implementation.AuthorController;

public class GetAuthorByNewsId implements Command {
    private final AuthorController authorController;
    private final Long id;

    public GetAuthorByNewsId(AuthorController authorController, Long id) {
        this.authorController = authorController;
        this.id = id;
    }
    @Override
    public Object execute() {
        return authorController.getAuthorByNewsId(id);
    }
}
