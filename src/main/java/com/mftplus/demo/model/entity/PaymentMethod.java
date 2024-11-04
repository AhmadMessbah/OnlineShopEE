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
@Table(name = "payment_methods")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "paymentMethodSeq", sequenceName = "payment_method_seq", allocationSize = 1)
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentMethodSeq")
    @Column(name = "payment_method_id")
    private Integer id;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "description")
    private String description;
}
