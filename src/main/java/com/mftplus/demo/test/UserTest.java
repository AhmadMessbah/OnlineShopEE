package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.service.UserService;

import java.util.List;

public class UserTest {
    public static void main(String[] args) throws Exception {
        Role role1=Role.builder()
                .roleName("buyer")
                .build();
        Role role2=Role.builder()
                .roleName("seller")
                .build();
        //todo:not work
        //  user.addRole(role);
        //  user.addRole(role1);

        User user = User.builder()
                .username("moomoo")
                .password("dd")
                .email("moo@yahoo.com")
                .roleList(List.of(role1))
                .build();

        User user2 = User.builder()
                .username("mobinA")
                .password("mo123")
                .email("momo@yahoo.com")
                .build();
//        System.out.println(UserService.getUserService().findById(1L).getRoleList());

//        System.out.println(UserService.getUserService().findByPassword("d"));
//        UserService.getUserService().save(user);
//        UserService.getUserService().save(user2);
//        System.out.println(user);
//        System.out.println(user2);

      //  System.out.println(UserService.getUserService().findByEmail("momo@yahoo.com"));
        //RoleService.save(role);
        //RoleService.save(role1);
        //user.setRoleList(List.of(role,role1));//todo:worked
        //UserService.save(user);
        //UserService.getUserService().save(user);
        //System.out.println("Save User Success"+user);
        //System.out.println(UserService.getUserService().findById(1L));
        // UserService.getUserService().edit(user);//todo : unEdited in db !!
        //UserService.getUserService().edit(UserService.getUserService().findById(1L));
        //UserService.getUserService().remove(1L);
        // System.out.println("User Removed-->"+user.getId());
    }
}
