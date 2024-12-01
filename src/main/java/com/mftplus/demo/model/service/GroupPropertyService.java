package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.GroupProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped

public class GroupPropertyService  implements Service<GroupProperty, Long>{
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(GroupProperty groupProperty) {
        entityManager.persist(groupProperty);
    }
    @Transactional
    @Override
    public void edit(GroupProperty groupProperty) {
        entityManager.merge(groupProperty);

    }

    @Transactional
    @Override
    public void remove(Long id) {
        GroupProperty groupProperty = entityManager.find(GroupProperty.class, id);
        entityManager.remove(groupProperty);

    }

    @Transactional
    @Override
    public GroupProperty findById(Long id) {
       return entityManager.find(GroupProperty.class, id);

    }

    @Override
    public List<GroupProperty> findAll() {
        Query query = entityManager.createQuery("select g from groupProEntity g", GroupProperty.class);
        return query.getResultList();
    }
}
