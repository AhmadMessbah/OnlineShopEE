package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.service.RoleService;

public class RoleTest {
    public static void main(String[] args) throws Exception {
        Role role1 = Role
                .builder()
               // .id(1L)
                .roleName("seller")
                .build();
//        Role role2 = Role
//                .builder()
//                .roleName("customer")
//                .build();
//        Role role3 = Role
//                .builder()
//                .roleName("buyer")
//                .build();
//        RoleService.getRoleService().save(role1);
//        RoleService.getRoleService().save(role2);
//        RoleService.getRoleService().save(role3);
//        System.out.println("Role 1 Saved-->"+role1);
//        System.out.println("Role 2 Saved-->"+role2);
//        System.out.println("Role 3 Saved-->"+role3);
//        System.out.println("All Roles-->"+RoleService.getRoleService().findAll());
//        System.out.println(RoleService.getRoleService().findById(1L).getRoleName());
//        System.out.println(RoleService.getRoleService().findById(1L).getVersionId());
//        RoleService.getRoleService().edit(role1);todo --> no editing...
//        System.out.println(role1.getRoleName());
//        System.out.println(RoleService.getRoleService().findByRoleName("r"));
//        System.out.println(RoleService.getRoleService().findByRoleName("z"));

        //   RoleService.getRoleService().findByRoleName("s");
    }
}
