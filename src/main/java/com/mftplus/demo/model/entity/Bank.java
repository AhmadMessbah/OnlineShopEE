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
@NamedQueries({
        @NamedQuery(name = "Bank.findById", query = "SELECT b FROM BankEntity b WHERE b.id = :id"),
        @NamedQuery(name = "Bank.findByName", query = "SELECT b FROM BankEntity b WHERE b.name LIKE :name"),
        @NamedQuery(name = "Bank.findByAccountNumber", query = "SELECT b FROM BankEntity b WHERE b.accountNumber = :accountNumber"),
        @NamedQuery(name = "Bank.findByBranchCode", query = "SELECT b FROM BankEntity b WHERE b.branchCode = :branchCode")
})
public class Bank extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_seq")
    @SequenceGenerator(name = "bank_seq", sequenceName = "bank_seq", allocationSize = 1)
    private Long id;

    @Column(name = "bank_name")
    private String name;

    @Column(name = "bank_accountNumber")
    private String accountNumber;

    @Column(name = "bank_branchCode")
    private long branchCode;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
