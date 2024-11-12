package com.mftplus.demo.model.entity;
import com.mftplus.demo.model.entity.enums.DeliveryMethod;
import com.mftplus.demo.model.entity.enums.DeliveryStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name= "deliveryEntity")
@Table(name = "delivery_tbl")
public class Delivery {

    @Id
    @SequenceGenerator(name = "deliverySeq", sequenceName = "delivery_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deliverySeq")
    private Long id;


//    @OneToOne(mappedBy = "delivery")
//    private Order order;

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;
    @Column(name = "tracking_number", nullable = false)

    private String trackingNumber;
    @Column(name = "carrier")
    private String carrier;


    private double shippingCost;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private DeliveryMethod deliveryMethod;

    private String phoneNumber;
    private LocalDateTime shippedDate;
    private LocalDateTime deliveredDate;
}
