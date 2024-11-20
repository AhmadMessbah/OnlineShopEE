package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "tGroupEntity")
@Table(name = "ticketGroup_tbl")
public class TicketGroup extends Base {
    @Id
    @SequenceGenerator(name = "groupSeq", sequenceName = "ticketGroup_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupSeq")
    @JsonProperty("ردیف :")
    private Long id;

    @Column(name = "g_name")
    @JsonProperty("نام :")
    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<TicketGroup> childList;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonProperty("منبع :")
    private TicketGroup parent;

//    public void addChild(TicketGroup child) {
//        if (childList == null) {
//            childList = new ArrayList<>();
//        }
//        childList.add(child);
//
//    }
//    @PrePersist
//    public void addChild(){         //todo(1)
//        if(childList == null){
//            childList = new ArrayList<>();
//            childList.add(parent);
//        }
//
//
//    }

}