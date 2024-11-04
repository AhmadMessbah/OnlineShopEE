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

@Entity(name = "roleEntity")
@Table(name = "role_tbl")


public class Role extends Base {

    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
    private Long id;

    @Column(name = "role_name", length = 15, nullable = false)
    @Pattern(regexp = "^[a-zA-Z]{2,15}$", message = "invalid role name !")
    private String roleName;


    @OneToMany(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    @JoinTable(name = "role_premission")
    private List<Permission> permission = new ArrayList<>();

//    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_Owner")
//    private User user;

}
