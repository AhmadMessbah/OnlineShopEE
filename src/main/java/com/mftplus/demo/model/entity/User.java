package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "UserEntity")
@Table(name = "user_tbl")
public class User {
    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    private long id;

    @Column(name = "user_username", length = 30,unique = true, nullable = false)
    private String username;

    @Column(name = "user_password", length = 30)
    private String password;

    @Column(name = "user_email", length = 30)
    private String email;



    @OneToMany
    @JoinTable(name = "my_user_role")
    private List<Role> roleList = new ArrayList<>();

    public void addRole(Role role) {
        roleList.add(role);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
