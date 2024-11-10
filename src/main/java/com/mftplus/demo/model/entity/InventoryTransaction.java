package com.mftplus.demo.model.entity;
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

@Entity(name = "inventoryTransactionEntity")
@Table(name = "Inventory_Transaction_table")

public class InventoryTransaction extends Base {

    @Id
    @SequenceGenerator(name = "inventory_t_seq", sequenceName = "inventory_t_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_t_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name=("inventory"), foreignKey = @ForeignKey(name="fk-inventoryTrans_inventory"))
    private Inventory inventory;

    @OneToOne
    @JoinColumn(name=("product"), foreignKey = @ForeignKey(name="fk-inventoryTrans_product"))
    private Product product;

    @OneToOne
    @JoinColumn(name = ("order"), foreignKey= @ForeignKey(name ="fk-inventoryTrans-order"))
    private Order order;

    @Pattern(regexp = "\\d", message = "Invalid Number")
    @Column(name = "count", length = 10)
    private int count;

    @Enumerated(EnumType.ORDINAL)
    private InventoryStatus status;

}
