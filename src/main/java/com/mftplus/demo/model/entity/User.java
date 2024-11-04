package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

public class User extends Base {
    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    private long id;

    @Column(name = "user_username", length = 30, unique = true, nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]{3,30}$", message = "invalid username !")
    private String username;

    @Column(name = "user_password", length = 30, nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]{3,30}$", message = "invalid password !")
    private String password;

    @Column(name = "user_email", length = 30, nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]{3,30}$", message = "invalid email !")
    private String email;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "my_user_role")
    private List<Role> roleList = new ArrayList<>();
}
