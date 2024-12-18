package com.mftplus.demo.model.entity;


import com.mftplus.demo.model.entity.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name = "orderEntity")
@Table(name = "order_tbl")
public class Order extends Base {
    @Id
    @SequenceGenerator(name = "orderSeq", sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private User user;

    @Column(name = "order_Date") //nullable = false
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;

    @Column(name = "total_amount") //nullable = false
    private double totalAmount;

    @Column(name = "discount", length = 10) //nullable = false
    private double discount;

    @Column(name = "tax", length = 10) //nullable = false
    private double tax;

    @Column(name = "shipping_cost") //nullable = false
    private double shippingCost;

    @OneToMany(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_items", foreignKey = @ForeignKey(name = "my_fk"))
    @JoinTable(name = "order_orderItem", foreignKey = @ForeignKey(name = "my_fk"))
    private List<OrderItem> orderItems=new ArrayList<>();

//    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//    @JoinColumn(name = "delivery_id")
//    private List<Delivery> delivery;

    @Column(name = "bill_address")//, nullable = false
    private String billingAddress;

    @Column(name = "created_at")//, nullable = false
    private LocalDateTime createdAt;

    @Column(name = "updated_at")//, nullable = false
    private LocalDateTime updatedAt;

//    public void updateOrderStatus(OrderStatus orderStatus) {
//        this.orderStatus = orderStatus;
//    }

}
