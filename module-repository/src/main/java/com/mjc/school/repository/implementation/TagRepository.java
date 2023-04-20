package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.implementation.TagModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class TagRepository implements BaseRepository<TagModel,Long> {

    EntityManager entityManager = null;

    @Override
    @SuppressWarnings("unchecked")
    public List<TagModel> readAll() {
        return entityManager.createQuery("Select all From TagModel all").getResultList();
    }

    @Override
    public Optional<TagModel> readById(Long id) {
        return Optional.ofNullable(entityManager.find(TagModel.class, id));
    }

    @Override
    public TagModel create(TagModel entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public TagModel update(TagModel entity) {
        entityManager.getTransaction().begin();
        TagModel update = entityManager.getReference(TagModel.class, entity.getId());
        update.setName(entity.getName());
        entityManager.getTransaction().commit();
        return update;
    }

    @Override
    public boolean deleteById(Long id) {
        entityManager.getTransaction().begin();
        boolean delete = entityManager.createQuery("Delete From TagModel t Where t.id = :id").setParameter("id", id).executeUpdate() != 0;
        entityManager.getTransaction().commit();
        return delete;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }
}
