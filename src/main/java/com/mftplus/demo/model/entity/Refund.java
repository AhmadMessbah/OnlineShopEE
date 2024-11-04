package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "^[0-9]*\\.?[0-9]+$", message = "Invalid amount!")
    @Column(name = "amount")
    private Double amount;

    @Column(name = "refund_date")
    private Date refundDate;

    @Pattern(regexp = "^(PENDING|COMPLETED|REJECTED)$", message = "Invalid refund status!")
    @Column(name = "status")
    private String status;

    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,200}$", message = "Invalid description!")
    @Column(name = "description")
    private String description;
}
