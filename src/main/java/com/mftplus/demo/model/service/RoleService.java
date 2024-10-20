package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class RoleService implements Service<Role, Long> {

    @Getter
    private static RoleService roleService = new RoleService();

    private RoleService() {
    }

    @Override
    public void save(Role role) throws Exception {
        try (CrudRepository<Role, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(role);
        }
    }

    @Override
    public void edit(Role role) throws Exception {
        try (CrudRepository<Role, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(role);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Role, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Role.class);
        }
    }

    @Override
    public Role findById(Long id) throws Exception {
        try (CrudRepository<Role, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Role.class);
        }
    }

    @Override
    public List<Role> findAll() throws Exception {
        try (CrudRepository<Role, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Role.class);
        }
    }

    public List<Role> findByRoleName(String roleName) throws Exception {
        try (CrudRepository<Role, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roleName", "%" + roleName + "%");
            return crudRepository.findBy("Role.findByRoleName",params, Role.class );

        }
    }
}
