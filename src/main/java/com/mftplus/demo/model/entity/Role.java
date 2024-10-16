package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "roleEntity")
@Table(name = "role_tbl")
@NamedQueries({
        @NamedQuery(name = "Role.findByRoleName", query = "select rr from roleEntity rr where rr.roleName like : roleName and rr.deleted=false ")
})


public class Role extends Base {

    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
    private Long id;

    @Column(name = "role_name", length = 15, nullable = false)
    private String roleName;

}
