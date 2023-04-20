package com.mjc.school.service.dto;

public class TagDtoRequest {
    private Long id;
    private String name;

    public TagDtoRequest(){}

    public TagDtoRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
