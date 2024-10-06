package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.service.RoleService;

public class RoleTest {
    public static void main(String[] args) throws Exception {
        Role role = Role
                .builder()
                .id(1L)
                .roleName("admin")
                .build();
        RoleService.edit(role);
        System.out.println(role);


    }
}
