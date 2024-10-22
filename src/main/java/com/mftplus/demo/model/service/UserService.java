package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class UserService implements Service<User, Long> {

    @Getter
    private static UserService userService = new UserService();

    private UserService() {
    }


    @Override
    public void save(User user) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(user);
        }
    }

    @Override
    public void edit(User user) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(user);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, User.class);
        }
    }

    @Override
    public User findById(Long id) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, User.class);
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(User.class);
        }
    }

    public User findByUsername(String username) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username + "%");
            List<User> users = crudRepository.findBy("User.findByUsername", params, User.class);
            return (users.isEmpty()) ? null : users.get(0);
        }
    }

    public List<User> findByPassword(String password) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("password", "%" + password + "%");
            return crudRepository.findBy("User.findByPassword", params, User.class);
        }
    }

    public User findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username + "%");
            params.put("password", password + "%");
            List<User> users = crudRepository.findBy("User.findByUsernameAndPassword", params, User.class);
            return (users.isEmpty()) ? null : users.get(0);
        }
    }

    public User findByEmail(String email) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("email", "%" + email + "%");
            List<User>users = crudRepository.findBy("User.findByEmail", params, User.class);
            return (users.isEmpty()) ? null : users.get(0);
        }
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
