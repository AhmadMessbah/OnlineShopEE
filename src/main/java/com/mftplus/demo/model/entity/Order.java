package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "OrderEntity")
@Table(name = "order_tbl")
public class Order {
    @Id
    @SequenceGenerator(name = "orderSeq", sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
    private Long id;

//    private Person seller; todo
//    private Person customer;
//    private Delivery delivery;

    @Column(name = "recive_time", nullable = false)
    private LocalDateTime reciveTime;

    @Column(name = "total_cost", nullable = false)
    private Long totalCost;

    @Column(name = "discount", nullable = false)
    private Long discount;

    @Column(name = "oder_Item", nullable = false)
    private OrderItem orderItem;


    @Override
    public String toString(){
        return new Gson().toJson(this);
    };

}
