package com.mftplus.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class FinancialTransaction {
    @Id
    long id;
    LocalDate date;
    long tracingCode;
//    User user ;
}
