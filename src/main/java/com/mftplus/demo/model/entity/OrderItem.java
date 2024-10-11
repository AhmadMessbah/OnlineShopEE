package com.mftplus.demo.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "OrderItemEntity")
@Table(name = "order_item_tbl")
public class OrderItem {

    @Id
    @SequenceGenerator(name = "orderItemSeq", sequenceName = "orderItem_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItemSeq")
    private Long id;

    @Column(name = "discount", length = 5, nullable = false)
    private int discount;

    @Column(name = "pure_amont", length = 5, nullable = false)
    private int pure_amount;

}
