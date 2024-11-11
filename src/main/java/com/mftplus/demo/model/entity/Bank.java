package com.mftplus.demo.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity(name = "BankEntity")
@Table(name = "banks_tbl")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankSeq")
    @Column(name = "bank_id")
    private long id;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "Invalid bank name!")
    @Column(name = "bank_name", length = 50)
    private String name;

    @Pattern(regexp = "^[0-9]{8,20}$", message = "Invalid bank account number!")
    @Column(name = "account_number", length = 20)
    private String accountNumber;

    @OneToMany(mappedBy = "bank")
    private List<Transaction> transactions;
}
