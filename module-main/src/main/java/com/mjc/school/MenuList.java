package com.mjc.school;

public enum MenuList {
    CREATE_NEWS(1,"Create News"),
    CREATE_AUTHOR(2,"Create Author"),
    CREATE_TAG(3,"Create TAG"),
    GET_ALL_NEWS(4,"Get All News"),
    GET_ALL_AUTHORS(5,"Get All Authors"),
    GET_ALL_TAGS(6,"Get All Tags"),
    GET_NEWS_BY_ID(7,"Get News By Id"),
    GET_AUTHOR_BY_ID(8,"Get Author By Id"),
    GET_TAG_BY_ID(9,"Get Tag By Id"),
    UPDATE_NEWS(10,"Update News"),
    UPDATE_AUTHOR(11,"Update Author"),
    UPDATE_TAG(12,"Update Tag"),
    DELETE_NEWS(13,"Delete News"),
    DELETE_AUTHOR(14,"Delete Author"),
    DELETE_TAG(15,"Delete Tag"),
    GET_AUTHOR_BY_NEWS_ID(16,"Get Author By News Id"),
    GET_TAGS_BY_NEWS_ID(17,"Get Tags By News Id"),
    GET_NEWS_BY_TAG_NAMES(18,"Get News By Tag Names, Tag Ids, Author Name, Title, Content"),
    EXIT(0,"Exit");

    private int id;
    private String values;

    MenuList(int id, String values) {
        this.id = id;
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
