package com.mftplus.demo.model.entity;
import com.google.gson.Gson;
import com.mftplus.demo.model.entity.enums.InventoryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "InventoryTransaction")
@Table(name = "Inventory-Transaction")

public class InventoryTransaction {

    @Id
    @SequenceGenerator(name = "inventory_t_seq", sequenceName = "inventory_t_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name=("inventory"), foreignKey = @ForeignKey(name="fk-inventoryTransaction_inventory"))
    private Inventory inventory;

    @OneToMany
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }

    @OneToOne
    @JoinColumn(name = ("order"), foreignKey= @ForeignKey(name ="fk-inventoryTransaction-order"))
    private Order order;

    @Column(name = "count", length = 10)
    private int count;

    @Enumerated(EnumType.ORDINAL)
    private InventoryStatus status;

    @Override
    public String toString() {
        return new Gson().toJson(this);}
}
