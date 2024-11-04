package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import jakarta.validation.constraints.Pattern;

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

    @Pattern(regexp = "^[a-zA-Z ]{1,50}$", message = "Invalid document type!")
    @Column(name = "doc_type")
    private String docType;

    @Pattern(regexp = "^(http|https)://.*", message = "Invalid file path!")
    @Column(name = "file_path")
    private String filePath;
}
