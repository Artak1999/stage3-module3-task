package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.OnDelete;
import com.mjc.school.repository.model.implementation.NewsModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<NewsModel,Long> {

    EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<NewsModel> readAll() {
        return entityManager.createQuery("Select all From NewsModel all").getResultList();
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        return Optional.ofNullable(entityManager.find(NewsModel.class, id));
    }

    @Override
    public NewsModel create(NewsModel entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public NewsModel update(NewsModel entity) {
        entityManager.getTransaction().begin();
        NewsModel update = entityManager.getReference(NewsModel.class, entity.getId());
        update.setAuthor(entity.getAuthor());
        update.setTag(entity.getTag());
        update.setTitle(entity.getTitle());
        update.setContent(entity.getContent());
        entityManager.getTransaction().commit();
        return update;
    }

    @Override
    @OnDelete
    public boolean deleteById(Long id) {
        entityManager.getTransaction().begin();
        boolean delete = entityManager.createQuery("Delete From NewsModel n Where n.id = :id").setParameter("id", id).executeUpdate() != 0;
        entityManager.getTransaction().commit();
        return delete;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }
}
