package com.mftplus.demo.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "OrderItemEntity")
@Table(name = "order_item_tbl")
public class OrderItem {
  @Id
    @SequenceGenerator(name = "orderItemSeq", sequenceName = "order_item_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItemSeq")
    @Column(name = "order_Id")
    private Long id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_quantity")
    private double quantity;

    @Column(name = "unit_price")
    private long unitPrice;

    @Transient
    private double totalPrice;

    public double getTotalPrice() {
        totalPrice = quantity * unitPrice;
        return totalPrice;
    }

}
