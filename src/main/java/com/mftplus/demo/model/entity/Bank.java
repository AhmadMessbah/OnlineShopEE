package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "BankEntity")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "bank_name")
    String name;

    @Column(name = "bank_accountNumber")
    String accountNumber;

    @Column(name = "bank_branchCode")
    long branchCode;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
