package model.entity;

import jakarta.transaction.Status;

public class Delivery {
    private Long id;
//    private enum transportation_modes;
    private Status status;
    private Person customer;
    private Person shipper;

}
