package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.service.RoleService;
import com.mftplus.demo.model.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws Exception {

        Role role=Role.builder()
                .roleName("buyer")
                .build();
        Role role1=Role.builder()
                .roleName("seller")
                .build();
        //todo:not work
      //  user.addRole(role);
      //  user.addRole(role1);

        User user=User.builder()
                .username("mones")
                .password("azzzz")
                .email("moonesss@gmail.com")
                .build();
        RoleService.save(role);
        RoleService.save(role1);
        user.setRoleList(List.of(role,role1));//todo:worked
        UserService.save(user);
        System.out.println("Save Success");

    }
}
