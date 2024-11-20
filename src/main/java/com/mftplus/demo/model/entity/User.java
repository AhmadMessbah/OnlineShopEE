package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

@Entity(name = "userEntity")
@Table(name = "user_tbl")

public class User extends Base {
    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @JsonProperty("ردیف :")
    private Long id;

    @Column(name = "username", length = 30)
    @Pattern(regexp = "^[a-zA-Z0-9]{3,30}$", message = "invalid username !")
    @JsonProperty("نام کاربری :")
    private String username;

    @Column(name = "password", length = 30)
    @JsonbTransient
    @Pattern(regexp = "^[a-zA-Z0-9]{3,30}$", message = "invalid password !")
    @JsonProperty("رمز عبور :")
    private String password;

    @Column(name = "user_email", length = 30)
    @Pattern(regexp = "^[a-zA-Z0-9.]{3,30}$", message = "invalid email !")
    @JsonProperty("ایمیل :")
    private String email;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "my_user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    @JsonProperty("عنوان کاربر :")
    private List<Role> roleList = new ArrayList<>();

}
