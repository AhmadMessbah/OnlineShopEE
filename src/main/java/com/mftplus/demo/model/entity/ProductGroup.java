package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity(name="productGroupEntity")
@Table(name = "productGroup_tbl")
@SuperBuilder



public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
//    @OneToMany
//    @Column(name = "productGroup-child")
//    private List<ProductGroup> child;

    @OneToOne
    @Column(name="productGroup-parent")
    private  ProductGroup parent;


}


