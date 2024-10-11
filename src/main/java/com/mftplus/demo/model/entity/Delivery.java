package com.mftplus.demo.model.entity;


import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name= "DeliveryEntity")
public class Delivery {
    @Id
    private Long id;

    private enum transportation_modes;
    private enum status;

    @Column (name = "Delivery_customer")
    private Person customer;

    @Column (name = "Shipper")
    private Person Shipper;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
