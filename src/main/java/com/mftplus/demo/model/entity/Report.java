package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "reports")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "reportSeq", sequenceName = "report_seq", allocationSize = 1)
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportSeq")
    @Column(name = "report_id")
    private Integer id;

    @Pattern(regexp = "^[a-zA-Z0-9 ]{2,100}$", message = "Invalid report description!")
    @Column(name = "description", length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
}
