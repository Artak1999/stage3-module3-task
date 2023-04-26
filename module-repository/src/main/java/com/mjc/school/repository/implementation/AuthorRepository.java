package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.OnDelete;
import com.mjc.school.repository.model.implementation.AuthorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel,Long> {

    private final EntityManager entityManager;
    @Autowired
    public AuthorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<AuthorModel> readAll() {
        return entityManager.createQuery("Select all From AuthorModel all").getResultList();
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.ofNullable(entityManager.find(AuthorModel.class, id));
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        entityManager.getTransaction().begin();
        AuthorModel update = entityManager.getReference(AuthorModel.class, entity.getId());
        update.setName(entity.getName());
        entityManager.getTransaction().commit();
        return update;
    }

    @Override
    @OnDelete
    public boolean deleteById(Long id) {
        entityManager.getTransaction().begin();
        boolean delete = entityManager.createQuery("Delete From AuthorModel a Where a.id = :id").setParameter("id", id).executeUpdate() != 0;
        entityManager.getTransaction().commit();
        return delete;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }
}
