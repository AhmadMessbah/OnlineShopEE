package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "transactions")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "transactionSeq", sequenceName = "transaction_seq", allocationSize = 1)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSeq")
    @Column(name = "transaction_id")
    private Integer id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "payment_method_id")
    private Integer paymentMethodId;

    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name = "refund_status")
    private String refundStatus;

    @Column(name = "refund_date")
    private Date refundDate;
}
