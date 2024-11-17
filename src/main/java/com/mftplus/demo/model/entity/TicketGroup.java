package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Slf4j
@ToString

@Entity(name = "tGroupEntity")
@Table(name = "ticketGroup_tbl")
public class TicketGroup extends Base {
    @Id
    @SequenceGenerator(name = "groupSeq",sequenceName = "ticketGroup_Seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "groupSeq")
    private Long id;

    @Column(name = "g_name")
    private String name;

    @OneToMany(mappedBy = "parent")
    private List<TicketGroup>childList=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
    private TicketGroup parent;

//    private void addChild(TicketGroup child) {
//        if (childList == null) {
//            childList = new ArrayList<>();
//        }
//        childList.add(child);
//    }

}
