package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import com.mftplus.demo.model.service.UserService;

import java.util.List;

public class UserTest {
    public static void main(String[] args) throws Exception {

//        Role role=Role.builder()
//                .roleName("buyer")
//                .build();
//        Role role1=Role.builder()
//                .roleName("seller")
//                .build();
        //todo:not work
        //  user.addRole(role);
        //  user.addRole(role1);

        User user = User.builder()
                .username("---")
                .password("d--d")
                .email("--@yahoo.com")
                .build();
        //RoleService.save(role);
        //RoleService.save(role1);
        //user.setRoleList(List.of(role,role1));//todo:worked
        //UserService.save(user);
        //UserService.getUserService().save(user);
        //System.out.println("Save User Success"+user);
        //System.out.println(UserService.getUserService().findById(1L));
        //UserService.getUserService().findByEmail("a");
        //System.out.println("Email :"+user.getEmail());
        // UserService.getUserService().edit(user);//todo : unEdited in db !!
        //UserService.getUserService().edit(UserService.getUserService().findById(1L));
        //System.out.println("User Updated Successfully :"+ user.getPassword());
        //UserService.getUserService().remove(1L);
        // System.out.println("User Removed-->"+user.getId());
    }
}
