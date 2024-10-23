//package com.mftplus.demo.model.entity;
//
//
//import com.google.gson.Gson;
//import jakarta.persistence.*;
//import lombok.*;
//import lombok.experimental.SuperBuilder;
//
//@NoArgsConstructor
//@Getter
//@Setter
//@SuperBuilder
//
//
//@Entity(name= "DeliveryEntity")
//public class Delivery {
//    @Id
//    @SequenceGenerator(name = "deliverySeq", sequenceName = "delivery_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deliverySeq")
//    private Long id;
//
//
//    //TODO: mehdi please check .
//    private enum transportation_modes;
//    private enum status;
//
//    @OneToOne
//    @Column (name = "Delivery_customer", length = 20, nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//
//    private Person customer;
//
//    @OneToOne
//    @Column (name = "Shipper", length = 20, nullable = false)
//    private Person Shipper;
//
//    @Override
//    public String toString() {
//        return new Gson().toJson(this);
//    }
//
//
//}
