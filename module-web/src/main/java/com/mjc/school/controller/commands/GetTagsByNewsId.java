package com.mjc.school.controller.commands;

import com.mjc.school.controller.command.Command;
import com.mjc.school.controller.implementation.TagController;

public class GetTagsByNewsId implements Command {

    private final TagController tagController;
    private final Long id;

    public GetTagsByNewsId(TagController tagController, Long id) {
        this.tagController = tagController;
        this.id = id;
    }

    @Override
    public Object execute() {
        return tagController.getTagByNewsId(id);
    }
}
