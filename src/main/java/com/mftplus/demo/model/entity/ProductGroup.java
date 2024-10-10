package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
    private String name;
  //  @OneToMany
//    private  List<ProductGroup> child;

    @ManyToOne
    private  ProductGroup parent;


}


