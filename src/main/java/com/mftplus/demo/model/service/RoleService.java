package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Role;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
public class RoleService implements Service<Role, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    @Transactional
    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
    }

    @Override
    @Transactional
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    @Transactional
    public List<Role> findAll() {
        Query query = entityManager.createQuery("select r from roleEntity r", Role.class);
        return query.getResultList();
    }

    @Transactional
    public List<Role> findByRoleName(String roleName) {
        Query query = entityManager.createQuery("select r from roleEntity r where r.roleName = :roleName", Role.class);
        query.setParameter("roleName", roleName);
        return query.getResultList();

    }

    @Transactional
    public Role findByUserPassAndUsername(String username, String password) {
        Query query = entityManager.createQuery("select r from roleEntity r where r.user.username = : username and r.user.password = : password", Role.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (Role) query.getSingleResult();

    }

    @Transactional
    public Role findByUserEmail(String email) {
        Query query = entityManager.createQuery("select r from roleEntity r where r.user.email = : email", Role.class);
        query.setParameter("email", email);
        return (Role) query.getSingleResult();

    }
}