package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class FinancialDoc {
    @Id
    long id;
    @Column(name = "FinancialDoc_docNumber")
    long docNumber;
    @Column(name = "FinancialDoc_date")
    LocalDate date;
    @Column(name = "FinancialDoc_description")
    String description;
    @OneToOne
    FinancialTransaction financialTransaction;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
