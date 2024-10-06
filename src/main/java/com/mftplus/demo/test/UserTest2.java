package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Role;
import com.mftplus.demo.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserTest2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mft");
        Role role=Role.builder().roleName("admin").build();
        User user=new User();
     //   user.getRoleList().add(role);
        user=User.builder()
                .username("mobi")
                .password("mooo")
                .email("eeeee@gmail.com")
                .build();

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(role);
        entityManager.persist(user);

        entityTransaction.commit();
        entityManager.close();
    }
}
