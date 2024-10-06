package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.Column;
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
    @Column(name = "FinancialTransaction_date")
    LocalDate date;
    @Column(name = "FinancialTransaction_tracingCode")
    long tracingCode;
    //User user ;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
