package com.mjc.school.repository.model.implementation;

import com.mjc.school.repository.model.BaseEntity;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "tag")
public class TagModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15)
    private String name;

    @ManyToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    List<NewsModel> news = new ArrayList<>();

    public TagModel() {}

    public TagModel(Long id, String name) {
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

    public List<NewsModel> getNews() {
        return news;
    }

    @Override
    public String toString() {
        return "TagModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
