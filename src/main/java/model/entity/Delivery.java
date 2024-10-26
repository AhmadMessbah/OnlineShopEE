package model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.entity.enums.DeliveryStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class Delivery {

    @Id
    @SequenceGenerator(name = "deliverySeq", sequenceName = "delivery_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deliverySeq")
    private Long id;

    private String orderId;
    private String deliveryAddress;
    private String recipientName;
    private String phoneNumber;
    private LocalDateTime shippedDate;
    private LocalDateTime deliveredDate;
    private String deliveryMethod;
    private String trackingNumber;
    private String carrier;
    private double shippingCost;
    private DeliveryStatus deliveryStatus;

}
