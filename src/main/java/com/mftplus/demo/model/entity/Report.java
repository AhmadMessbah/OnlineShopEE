package com.mftplus.demo.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
@Entity(name = "ReportEntity")
@Table(name = "reports_tbl")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportSeq")
    @Column(name = "report_id")
    private long id;

   // @Pattern(regexp = "^[a-zA-Z0-9 ]{2,100}$", message = "Invalid report description!")
    @Column(name = "description", length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
}
