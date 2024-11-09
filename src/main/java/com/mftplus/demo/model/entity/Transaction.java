package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.List;

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

    @Pattern(regexp = "^[0-9]{1,10}$", message = "Invalid amount!")
    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private FinancialDoc financialDoc;

    @OneToOne(mappedBy = "transaction")
    private Refund refund;

    @OneToMany(mappedBy = "transaction")
    private List<Report> reports;
}
