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
@Table(name = "bank_tbl")
public class Bank extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_seq")
    @SequenceGenerator(name = "bank_seq", sequenceName = "bank_seq", allocationSize = 1)
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
