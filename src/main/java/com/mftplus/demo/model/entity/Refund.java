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
@Table(name = "refunds")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "refundSeq", sequenceName = "refund_seq", allocationSize = 1)
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refundSeq")
    @Column(name = "refund_id")
    private Integer id;

    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "refund_date")
    private Date refundDate;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;
}
