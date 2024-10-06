package com.mftplus.demo.model.service;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.repository.RoleRepository;

public class RoleService {
    public static void save(Role role) throws Exception {

        try (RoleRepository roleRepository = new RoleRepository()) {
            roleRepository.save(role);
        }
    }
    public static void edit(Role role) throws Exception {

        try (RoleRepository roleRepository = new RoleRepository()) {
            roleRepository.edit(role);
        }
    }
}
