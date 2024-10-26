package model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "orderEntity")
@Table(name ="order_tbl")
public class Order {


    @Id
    @SequenceGenerator(name = "orderSeq", sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSeq")
      private Long id;
//    private Person seller;
//    private Person customer;
//    private Delivery delivery;

    @Column( name = "recieve_time", nullable = false)
    private LocalDateTime recieveTime;
    private Long total_cost;
    private int Discount;


//    private OrderItem orderItem;


}
