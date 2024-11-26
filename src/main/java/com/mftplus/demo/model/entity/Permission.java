package com.mftplus.demo.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

public class Permission extends Base {
    @Id
    @Column(name = "permission_name", length = 30)
//    @Pattern(regexp = "^[a-zA-Z\\s]{2,30}$", message = "invalid permission name!")
    @JsonProperty("امکان دسترسی :")
    @NotBlank(message = "Permission cant be Empty!")
    private String permissionName;

    @Column(name = "permission_id", length = 22)
    @JsonProperty("ردیف :")
//    @SequenceGenerator(name = "permissionSeq", sequenceName = "permission_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissionSeq")
    private Long id;
}
