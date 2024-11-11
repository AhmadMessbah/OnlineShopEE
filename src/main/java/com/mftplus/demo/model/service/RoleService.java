package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Slf4j
public class RoleService implements Service<Role, Long> {
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Transactional
    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Transactional
    @Override
    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
    }

    @Transactional
    @Override
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    @Override
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
    public List<Role> findByPermission(String permissionName) {
                                                //TODO-->> inja bayad cross join bezanam vali vaqti mizaram personam null mishe!!
        Query query = entityManager.createQuery("select r from roleEntity r join permissionEntity pp where pp.permissionName = : permissionName", Role.class);
        query.setParameter("permissionName", permissionName);
        return query.getResultList();

    }

}