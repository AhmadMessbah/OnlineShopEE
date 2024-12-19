package com.mftplus.demo.model.service;


import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequestScoped
@Loggable
@Slf4j
public class PermissionService {
    @Inject
    private RoleService roleService;

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;

    @Transactional
    @Loggable
    public void save(Permission permission) {
        entityManager.persist(permission);
    }

    @Transactional
    @Loggable
    public void edit(Permission permission) {
        entityManager.merge(permission);
    }

    @Transactional
    @Loggable
    public Permission remove(Long id) {
        Permission permission = entityManager.find(Permission.class, id);
        entityManager.remove(permission);
        return permission;
    }

    @Transactional
    @Loggable
    public List<Permission> findAll() {
        Query query = entityManager.createQuery("select pp from permissionEntity pp", Permission.class);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public Permission findById(Long id) {
        return entityManager.find(Permission.class, id);
    }

    @Transactional
    @Loggable
    public List<Permission> findByName(String permissionName) {
        Query query = entityManager.createQuery("select pp from permissionEntity pp where pp.permissionName=:permissionName", Permission.class);
        query.setParameter("permissionName", permissionName);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public List<Permission> createAnyThing(String create) {
        if (!roleService.findByRoleName("admin").isEmpty() && findByName("admin").contains(create)) {
            Query query = entityManager.createQuery("select r.roleName from roleEntity r cross join permissionEntity p where p.create=:create_save", Permission.class);
            query.setParameter("create_save", create);
            return query.getResultList();
        } else {
            return findAll();
        }
    }
}
