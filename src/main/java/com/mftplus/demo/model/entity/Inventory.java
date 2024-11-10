package com.mftplus.demo.model.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "inventoryEntity")
@Table(name = "inventory_table")

public class Inventory extends Base {

    @Id
    @SequenceGenerator(name = "inventory_seq", sequenceName = ("inventory_seq"), allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq")
    private Long id;

    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$",message = "Invalid Name")
    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,300}$",message = "Invalid Address")
    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Pattern(regexp = "[\\d{11}]",message = "Invalid Phone Number")
    @Column(name = "phone", length = 14, nullable = false)
    private String phone;

//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinColumn(name = "InventoryTransaction")
//    private List<InventoryTransaction> inventoryTransaction;

}
