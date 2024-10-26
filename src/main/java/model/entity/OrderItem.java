package model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.entity.enums.OrderStatus;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "orderItemEntity")
@Table(name = "order_items")

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

    @Column(name = "discount")
    private double discount;

    private double tax;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;


}
