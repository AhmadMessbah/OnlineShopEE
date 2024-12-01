package com.mftplus.demo.model.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Setter
@Getter
@SuperBuilder


@Entity(name = "productProEntity")
@Table(name = "pro_propertieValues")

public class ProductPropertyValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
//    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//    private Product product;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private GroupProperty groupProperty;

}
