package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
@NamedQueries({
        @NamedQuery(name = "FinancialTransaction.findById", query = "SELECT ft FROM FinancialTransaction ft WHERE ft.id = :id"),
        @NamedQuery(name = "FinancialTransaction.findByDate", query = "SELECT ft FROM FinancialTransaction ft WHERE ft.date = :date"),
        @NamedQuery(name = "FinancialTransaction.findByTracingCode", query = "SELECT ft FROM FinancialTransaction ft WHERE ft.tracingCode = :tracingCode"),
        @NamedQuery(name = "FinancialTransaction.findByUserId", query = "SELECT ft FROM FinancialTransaction ft WHERE ft.user.id = :userId")
})
public class FinancialTransaction extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_transaction_seq")
    @SequenceGenerator(name = "financial_transaction_seq", sequenceName = "financial_transaction_seq", allocationSize = 1)
    private long id;

    @Column(name = "financial_transaction_date")
    @NotNull
    @PastOrPresent
    private LocalDate date;

    @Column(name = "financial_transaction_tracing_code")
    @NotNull
    private long tracingCode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
