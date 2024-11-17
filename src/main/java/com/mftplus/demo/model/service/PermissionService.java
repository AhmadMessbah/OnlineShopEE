package com.mftplus.demo.model.service;


import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@Loggable
@Slf4j
public class PermissionService implements Service<Permission, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    public void save(Permission permission) {
        entityManager.persist(permission);
    }

    @Transactional
    public void edit(Permission permission) {
        entityManager.merge(permission);
    }

    @Transactional
    public void remove(Long id) {
        Permission permission = entityManager.find(Permission.class, id);
        entityManager.remove(permission);
    }

    @Transactional
    public List<Permission> findAll() {
        Query query = entityManager.createQuery("select pp from permissionEntity pp", Permission.class);
        return query.getResultList();
    }

    @Transactional
    public Permission findById(Long id) {
        return entityManager.find(Permission.class, id);
    }

    @Transactional
    public List<Permission> findByName(String permissionName) {
        Query query = entityManager.createQuery("select pp from permissionEntity pp where pp.permissionName=:permissionName", Permission.class);
        query.setParameter("permissionName", permissionName);
        return query.getResultList();
    }

}
