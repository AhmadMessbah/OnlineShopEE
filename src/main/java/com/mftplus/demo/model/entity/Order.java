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
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "OrderEntity")
@Table(name = "order_tbl")
public class Order {
    @Id
    @SequenceGenerator(name = "orderSeq", sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "order_Date", nullable = false)
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;
    @Column(name = "discount", length = 10, nullable = false)
    private double discount;
    @Column(name = "tax", length = 10, nullable = false)
    private double tax;
    @Column(name = "shipping_cost", nullable = false)
    private double shippingCost;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "order_items", foreignKey = @ForeignKey(name = "my_fk"))
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Column(name = "billing_address", nullable = false)
    private String billingAddress;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
