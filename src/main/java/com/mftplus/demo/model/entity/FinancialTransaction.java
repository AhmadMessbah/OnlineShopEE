package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "financial_transactions")
public class FinancialTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_transaction_seq")
    @SequenceGenerator(name = "financial_transaction_seq", sequenceName = "FINANCIAL_TRANSACTION_SEQ", allocationSize = 1)
    long id;

    @Column(name = "financial_transaction_date")
    LocalDate date;

    @Column(name = "financial_transaction_tracing_code")
    long tracingCode;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
