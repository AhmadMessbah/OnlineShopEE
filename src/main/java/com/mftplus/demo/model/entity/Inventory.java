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

@Entity(name = "Inventory")
@Table(name = "Inventory_Table")

public class Inventory {
    @Id
    @SequenceGenerator(name = "inventory_seq", sequenceName = ("inventory_seq"), initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "phone", length = 14, nullable = false)
    private String phone;

    @Override
    public String toString() {
        return new Gson().toJson(this);}
}
