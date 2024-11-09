package com.mftplus.demo.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

@Entity(name = "permissionEntity")
@Table(name = "permission_tbl")
public class Permission {
    @Id
    @SequenceGenerator(name = "permissionSeq" , sequenceName = "permission_seq" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "permissionSeq")

    private Long id;

    @Column(name = "permission_name",length = 30)
    @Pattern(regexp = "^[a-zA-Z]{2,30}$" , message = "invalid permission name!")
    private String permissionName;
}
