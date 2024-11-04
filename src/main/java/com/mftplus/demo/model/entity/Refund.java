package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

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

    @Pattern(regexp = "^[0-9]{1,10}$", message = "Invalid refund amount!")
    @Column(name = "amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
}
