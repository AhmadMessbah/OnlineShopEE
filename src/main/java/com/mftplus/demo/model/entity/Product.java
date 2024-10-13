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

@Entity(name="productEntity")
@Table(name = "product_tbl")
@SuperBuilder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column( name="name", length = 20 ,nullable = false)
    private String name;
    @Column(name = "price", length= 20  ,unique = true  )
    private int price;
    @Column(name = "stock" , nullable = false)
    private int stock;
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
