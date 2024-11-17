package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "tGPropertyValueEntity")
@Table(name = "tGroup_propertyVal_tbl")
public class TicketPropertyValue extends Base{
    @Id
    @SequenceGenerator(name = "tGPValueSeq", sequenceName = "ticketGPValueSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tGPValueSeq")
    private Long id;
    @Column(name = "property_value")
    private String propertyValue;
}
