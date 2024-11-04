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
@Table(name = "payment_methods")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "paymentMethodSeq", sequenceName = "payment_method_seq", allocationSize = 1)
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentMethodSeq")
    @Column(name = "payment_method_id")
    private Integer id;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "Invalid payment method name!")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Transaction> transactions;
}
