package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@ApplicationScoped
//@Loggable //todo
@Slf4j
public class UserService {    // implements Service<User, Long>
    @Inject
    private RoleService roleService;


    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;
//    @Inject
//    private RoleService roleService;


    @Transactional
//    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
//    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional
//    @Override
    public User remove(String username) {
        User user = entityManager.find(User.class, username);
        entityManager.remove(user);
        return user;
    }

    @Transactional
//    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);

    }

    @Transactional
//    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("select u from userEntity u", User.class);
        return query.getResultList();
    }

    @Transactional
    public User findByUsername(String username) {
        List<User> userList = entityManager
                .createQuery("select u from userEntity u where u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        return (userList.isEmpty()) ? null : userList.get(0);
    }

    @Transactional
    public List<User> findByPassword(String password) {
        Query query = entityManager.createQuery("select u from userEntity u where u.password = : password", User.class);
        query.setParameter("password", password);
        return query.getResultList();
    }

    @Transactional
    public User findByUsernameAndPassword(String username, String password) {
        Query query = entityManager.createQuery("select u from userEntity u where u.username = :username and u.password = : password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }

    @Transactional
    public User findByEmail(String email) {
        Query query = entityManager.createQuery("select u from userEntity u where u.email = :email", User.class);
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

    @Transactional
    public List<User> findByRoleName(String roleName) {
        Query query = entityManager.createQuery("select u from userEntity u cross join roleEntity r where r.roleName=:roleName", User.class);
        query.setParameter("roleName", roleName);
        return query.getResultList();

//        if (roleService.findByRoleName(roleName) != null && findByUsername(roleName) != null) {
//            Query query = entityManager.createQuery("select u from userEntity u cross join roleEntity r where r.roleName=:roleName", User.class);
//            query.setParameter("roleName", roleName);
//            return query.getResultList();
//        } else {
//            try {
//                throw new NoRoleException();
//            } catch (NoRoleException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    @Transactional
    public Set<Permission> findPermissionsByUsername(String username) {
//        Set<Role> roleSet = roleService.findByUsername(username);
//        SecurityContextHolder
        Role role = Role.builder().roleName("admin").build();
        return role.getPermissionSet();
    }
}