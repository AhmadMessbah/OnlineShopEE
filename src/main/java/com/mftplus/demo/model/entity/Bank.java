package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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

    @Column(name = "name")
    private String name;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "iban")
    private String iban;

    @Column(name = "swift_code")
    private String swiftCode;
}
