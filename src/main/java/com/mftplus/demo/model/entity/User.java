package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name = "userEntity")
@Table(name = "user_tbl")
@NamedQueries({
        @NamedQuery(name = "User.findByUsername", query = "select uu from userEntity uu where uu.username like : username and uu.deleted=false "),
        @NamedQuery(name = "User.findByPassword", query = "select uu from userEntity uu where uu.password like : password and uu.deleted=false "),
        @NamedQuery(name = "User.findByEmail", query = "select uu from userEntity uu where uu.email like : email and uu.deleted=false ")
})

public class User extends Base {
    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    private long id;

    @Column(name = "user_username", length = 30, unique = true, nullable = false)
    private String username;

    @Column(name = "user_password", length = 30, nullable = false)
    private String password;

    @Column(name = "user_email", length = 30, nullable = false)
    private String email;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "my_user_role")
    private List<Role> roleList = new ArrayList<>();

}
