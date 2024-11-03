package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name="productEntity")
@Table(name = "product_tbl")


public class Product extends Base {
    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "productSeq" )
    private Long id;

    @Column( name="name", length = 30 ,nullable = false)
    @Pattern(regexp = "^[a-zA-Z]{3,30}$",message = "invalid name!")
    private String name;

    @Column(name = "price", length= 30)
    @Pattern(regexp = "^[0-9]{2,30}$",message = "invalid price")
    private Float price;

//    @Column(name = "stock" , nullable = false)
//    private int stock;



}