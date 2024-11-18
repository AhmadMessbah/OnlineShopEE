package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "paymentEntity")
@Table(name = "payment_tbl")
public class Payment {

    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @JsonProperty("Payment ID")
    private Long id;

    @Column(name = "doc_number", nullable = false, unique = true)
    @NotNull(message = "Document number is required!")
    @Pattern(regexp = "^[0-9]{1,15}$", message = "Invalid document number!")
    @JsonProperty("Document Number")
    private Long docNumber;

    @Column(name = "payment_date", nullable = false)
    @NotNull(message = "Payment date is required!")
    @JsonProperty("Payment Date")
    private LocalDate date;

    @Column(name = "description", length = 255)
    @Pattern(regexp = "^[A-Za-z0-9\\s]{0,255}$", message = "Invalid description!")
    @JsonProperty("Description")
    private String description;
}
