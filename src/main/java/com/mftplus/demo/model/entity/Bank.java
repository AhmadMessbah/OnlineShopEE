package com.mftplus.demo.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity

public class Bank {
    @Id
    long id;
    @Column(name = "Bank_name")
    String name;
    @Column(name = "Bank_accountNumber")
    String accountNumber;
    @Column(name = "Bank_branchCode")
    long branchCode;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
