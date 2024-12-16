package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.entity.Person;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@ApplicationScoped
//@Loggable
@Slf4j
public class RoleService{
    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Transactional

    public void save(Role role) {
        entityManager.persist(role);
    }

    @Transactional

    public void edit(Role role) {
        entityManager.merge(role);
    }

    @Transactional

    public Role remove(Long id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
        return role;
    }

@Transactional

public Role findById(Long id) {
    return entityManager.find(Role.class, id);
}

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
public List<Role> findByUsername(String username) {
    Query query = entityManager.createQuery("select u.roleList from  userEntity  u where u.username=:username", Role.class);
    query.setParameter("username", username);
    return query.getResultList();

}

@Transactional
public List<Role> findByPermission(String permissionName) {
    Query query = entityManager.createQuery("select r from roleEntity r cross join permissionEntity pp where pp.permissionName = : permissionName", Role.class);
    query.setParameter("permissionName", permissionName);
    return query.getResultList();

}

}