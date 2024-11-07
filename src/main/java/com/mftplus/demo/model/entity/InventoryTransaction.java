package com.mftplus.demo.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mftplus.demo.model.entity.enums.InventoryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "inventoryTransactionEtity")
@Table(name = "Inventory-Transaction")
@NamedQueries({
        @NamedQuery(name="InventoryTransaction.findByInventoryId", query = "select oo from inventoryTransactionEtity oo where oo.inventory.id = :inventory"),
        @NamedQuery(name ="InventoryTransaction.findByProductId", query = "select oo from inventoryTransactionEtity oo where oo.product.id = :product"),
        @NamedQuery(name ="InventoryTransaction.findByOrderId", query = "select oo from inventoryTransactionEtity oo where oo.order.id = :order")
})

public class InventoryTransaction extends Base {

    @JsonProperty("Num")
    @Id
    @SequenceGenerator(name = "inventory_t_seq", sequenceName = "inventory_t_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name=("inventory"), foreignKey = @ForeignKey(name="fk-inventoryTrans_inventory"))
    private Inventory inventory;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name=("product"), foreignKey = @ForeignKey(name="fk-inventoryTrans_product"))
    private Product product;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = ("order"), foreignKey= @ForeignKey(name ="fk-inventoryTrans-order"))
    private Order order;

    @JsonProperty("Co")
    @Pattern(regexp = "\\d", message = "Invalid Number")
    @Column(name = "count", length = 10)
    private int count;

    @Enumerated(EnumType.ORDINAL)
    private InventoryStatus status;

//    @Override
//    public String toString() {
//        return new Gson().toJson(this);}
}
