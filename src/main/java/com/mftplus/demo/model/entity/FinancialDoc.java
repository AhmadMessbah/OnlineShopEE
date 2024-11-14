package com.mftplus.demo.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Entity(name = "FinancialDocEntity")
@Table(name = "financial_docs_tbl")
public class FinancialDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financialDocSeq")
    @Column(name = "doc_id")
    private long id;

    @Pattern(regexp = "^[a-zA-Z0-9 ]{2,50}$", message = "Invalid document name!")
    @Column(name = "doc_name", length = 50)
    private String name;

    @OneToMany(mappedBy = "financialDoc")
    private List<Transaction> transactions;
}
