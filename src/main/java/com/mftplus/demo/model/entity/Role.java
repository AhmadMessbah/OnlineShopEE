package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "roleEntity")
@Table(name = "role_tbl")


public class Role {

    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
    private Long id;

    @Column(name = "role_name", length = 15, nullable = false)
    private String roleName;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
