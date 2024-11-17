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

@Entity(name = "tGroupPropertyEntity")
@Table(name = "tGroup_property_tbl")
public class TGroupProperty extends Base {
    @Id
    @SequenceGenerator(name = "tGroupPropSeq", sequenceName = "ticketGPropertySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tGroupPropSeq")
    private Long id;
    @Column(name = "property_name")
    private String name;
}
