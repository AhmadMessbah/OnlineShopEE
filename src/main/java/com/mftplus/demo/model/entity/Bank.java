package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@Entity
@Table(name = "banks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "bankSeq", sequenceName = "bank_seq", allocationSize = 1)
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankSeq")
    @Column(name = "bank_id")
    private Integer id;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "Invalid bank name!")
    @Column(name = "bank_name")
    private String name;

    @Pattern(regexp = "^[0-9]{8,20}$", message = "Invalid bank account number!")
    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "bank")
    private List<Transaction> transactions;
}
