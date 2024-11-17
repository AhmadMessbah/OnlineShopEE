package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Slf4j
@ToString

@Entity(name = "messageEntity")
@Table(name = "message_tbl")
public class Message extends Base {
    @Id
    @SequenceGenerator(name = "messageSeq", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageSeq")
    private Long id;

    @Column(name = "text",length = 254)
    private String text;

    @Column(name = "title")
    private String title;

    @Column(name = "date_time")
    private String dateTime;

    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    private User user;


}
