package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "inventoryEntity")
@Table(name = "Inventory_Table")
@NamedQueries({
        @NamedQuery(name="Inventory.findByTitle", query = "select oo from inventoryEntity oo where oo.title like :titel"),
        @NamedQuery(name ="Inventor.findByAddress", query = "select oo from inventoryEntity oo where oo.address like :address"),
        @NamedQuery(name ="Inventor.findByPhone", query = "select oo from inventoryEntity oo where oo.phone like :phone")
        })

public class Inventory extends Base {
    @JsonProperty("Num")
    @Id
    @SequenceGenerator(name = "inventory_seq", sequenceName = ("inventory_seq"), initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("Name")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$",message = "Invalid Name")
    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @JsonProperty("Loc")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,300}$",message = "Invalid Address")
    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @JsonProperty("Call")
    @Pattern(regexp = "\\d{11}",message = "Invalid Phone Number")
    @Column(name = "phone", length = 14, nullable = false)
    private String phone;

}
