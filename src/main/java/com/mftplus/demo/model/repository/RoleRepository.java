package com.mftplus.demo.model.repository;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.utils.JpaProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class RoleRepository implements AutoCloseable {

    private EntityManager entityManager;

    public void save(Role role) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(role);
        transaction.commit();
    }

    public void edit(Role role) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(role);
        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
        transaction.commit();
    }

    public Role findById(Long id) {
        entityManager = JpaProvider.getJpa().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        return entityManager.find(Role.class, id);
    }
 //   public List<Role> findAll() {}


    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
