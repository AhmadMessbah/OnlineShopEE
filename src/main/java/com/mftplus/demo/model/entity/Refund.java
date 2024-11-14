package com.mftplus.demo.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Entity(name = "RefundEntity")
@Table(name = "refunds_tbl")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refundSeq")
    @Column(name = "refund_id")
    private long id;

    //@Pattern(regexp = "^[0-9]{1,10}$", message = "Invalid refund amount!")
    @Column(name = "amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
}
