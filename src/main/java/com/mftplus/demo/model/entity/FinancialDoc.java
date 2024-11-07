package com.mftplus.demo.model.entity;

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
@Entity(name = "FinancialDocEntity")
@NamedQueries({
        @NamedQuery(name = "FinancialDoc.findById", query = "SELECT f FROM FinancialDocEntity f WHERE f.id = :id"),
        @NamedQuery(name = "FinancialDoc.findByDocNumber", query = "SELECT f FROM FinancialDocEntity f WHERE f.docNumber = :docNumber"),
        @NamedQuery(name = "FinancialDoc.findByDate", query = "SELECT f FROM FinancialDocEntity f WHERE f.date = :date"),
        @NamedQuery(name = "FinancialDoc.findByDescription", query = "SELECT f FROM FinancialDocEntity f WHERE f.description LIKE :description"),
        @NamedQuery(name = "FinancialDoc.findByTransactionId", query = "SELECT f FROM FinancialDocEntity f WHERE f.financialTransaction.id = :transactionId")
})
public class FinancialDoc extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_doc_seq")
    @SequenceGenerator(name = "financial_doc_seq", sequenceName = "financial_doc_seq", allocationSize = 1)
    private long id;

    @Column(name = "financialDoc_docNumber")
    @NotNull
    private long docNumber;

    @Column(name = "financialDoc_date")
    @NotNull
    @PastOrPresent
    private LocalDate date;

    @Column(name = "financialDoc_description")
    private String description;

//    @OneToOne
//    @JoinColumn(name = "financialTransaction_id")
//    private FinancialTransaction financialTransaction;
//
//    @Override
//    public String toString() {
//        return new Gson().toJson(this);
//    }
}
