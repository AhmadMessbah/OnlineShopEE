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

@Entity(name = "ticketEntity")
@Table(name = "ticket_tbl")
public class Ticket extends Base {
    @Id
    @SequenceGenerator(name = "ticketSeq", sequenceName = "ticketSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketSeq")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "resp_status")
    private String responseType;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private TicketGroup ticketGroup;


}
