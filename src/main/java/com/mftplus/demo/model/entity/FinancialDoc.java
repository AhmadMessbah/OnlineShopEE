package com.mftplus.demo.model.entity;

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
    long docNumber;
    LocalDate date;
    String description;
    @OneToOne
    FinancialTransaction financialTransaction;
}
