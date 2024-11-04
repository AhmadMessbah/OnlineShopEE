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
@Table(name = "financial_docs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "financialDocSeq", sequenceName = "financial_doc_seq", allocationSize = 1)
public class FinancialDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financialDocSeq")
    @Column(name = "doc_id")
    private Integer id;

    @Pattern(regexp = "^[a-zA-Z0-9 ]{2,50}$", message = "Invalid document name!")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "financialDoc")
    private List<Transaction> transactions;
}
