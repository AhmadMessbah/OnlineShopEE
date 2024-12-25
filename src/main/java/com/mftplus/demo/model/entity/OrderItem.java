package com.mftplus.demo.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "OrderItemEntity")
@Table(name = "order_item_tbl")
public class OrderItem {
    @Id
    @SequenceGenerator(name = "orderItemSeq", sequenceName = "order_item_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItemSeq")
    @Column(name = "order_Id")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "product", foreignKey = @ForeignKey(name = "fk_ord_item_product"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Transient
    private double amount;

    private double quantity;
    private double price;

    public double getAmount() {
        amount = quantity * price;
        return amount;
    }

}
