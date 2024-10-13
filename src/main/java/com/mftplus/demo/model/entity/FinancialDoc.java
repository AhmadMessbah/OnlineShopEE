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

@Entity(name = "FinancialDocEntity")
public class FinancialDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_doc_seq")
    @SequenceGenerator(name = "financial_doc_seq", sequenceName = "FINANCIAL_DOC_SEQ", allocationSize = 1)
    long id;

    @Column(name = "financialDoc_docNumber")
    long docNumber;

    @Column(name = "financialDoc_date")
    LocalDate date;

    @Column(name = "financialDoc_description")
    String description;

    @OneToOne
    FinancialTransaction financialTransaction;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
