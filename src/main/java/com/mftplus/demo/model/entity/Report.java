package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import jakarta.validation.constraints.Pattern;
import java.util.Date;

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

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "transaction_id")
    private Integer transactionId;

    @Pattern(regexp = "^[a-zA-Z ]{1,50}$", message = "Invalid report type!")
    @Column(name = "report_type")
    private String reportType;

    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,200}$", message = "Invalid description!")
    @Column(name = "description")
    private String description;

    @Column(name = "report_date")
    private Date reportDate;

    @Pattern(regexp = "^(OPEN|CLOSED)$", message = "Invalid status!")
    @Column(name = "status")
    private String status;
}
