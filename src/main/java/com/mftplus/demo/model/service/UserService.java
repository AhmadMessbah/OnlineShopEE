package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Permission;
import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.utils.Loggable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.security.enterprise.SecurityContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@RequestScoped
//@Loggable //todo
@Slf4j
public class UserService {    // implements Service<User, Long>
    @Inject
    private RoleService roleService;

    @Inject
    private SecurityContext securityContext;

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Transactional
    @Loggable
    public Object save(User user) {
        entityManager.persist(user);
        return "this is for admin" + user;
    }

    @Transactional
    @Loggable
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public User remove(String username) {
        User user = entityManager.find(User.class, username);
        entityManager.remove(user);
        return user;
    }

    @Transactional
    public User findById(Long id) {
        return entityManager.find(User.class, id);

    }

    @Transactional
    @Loggable
//    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("select u from userEntity u", User.class);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public User findByUsername(String username) {
        List<User> userList = entityManager
                .createQuery("select u from userEntity u where u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        return (userList.isEmpty()) ? null : userList.get(0);
    }

    @Transactional
    @Loggable
    public List<User> findByPassword(String password) {
        Query query = entityManager.createQuery("select u from userEntity u where u.password = : password", User.class);
        query.setParameter("password", password);
        return query.getResultList();
    }

    @Transactional
    @Loggable
    public User findByUsernameAndPassword(String username, String password) {
        Query query = entityManager.createQuery("select u from userEntity u where u.username = :username and u.password = : password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }

    @Transactional
    @Loggable
    public User findByEmail(String email) {
        Query query = entityManager.createQuery("select u from userEntity u where u.email = :email", User.class);
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

    @Transactional
    @Loggable
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

    @Transactional      //todo
    @Loggable
    public Set<Permission> findPermissionsByUsername(String username) {

        //      securityContext.getCallerPrincipal().getName();
        List<Role> roleList = roleService.findByUsername(username);
        Role role = new Role();
        //  Role role = roleSet.get(0);

//        securityContext.isCallerInRole("admin");todo

//        Set<Role> roleSet = roleService.findByUsername(username);
//        SecurityContextHolder
//        Role role = Role.builder().roleName("admin").build();

        return role.getPermissionSet();
    }
}