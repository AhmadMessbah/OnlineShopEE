package com.mftplus.demo.model.service;

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
public class UserService implements Service<User, Long> {

    @PersistenceContext(unitName = "mft")
    private EntityManager entityManager;


    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);

    }

    @Transactional
    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("select u from userEntity u", User.class);
        return query.getResultList();
    }

    @Transactional
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("select u from userEntity u where u.username = :username", User.class);
        query.setParameter("username", username);
        return (User) query.getSingleResult();
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

//    public List<User> findByRoleName(String role) throws Exception {
//        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
//            HashMap<String, Object> params = new HashMap<>();
//            params.put("roleList", role);
//            if (role.isEmpty()) {
//                return null;
//            } else {
//                return crudRepository.findBy("User.findByRoleName",params, User.class );
//            }
//        }
//    }
}
