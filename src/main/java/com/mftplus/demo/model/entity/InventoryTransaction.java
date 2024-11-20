package com.mftplus.demo.model.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mftplus.demo.model.entity.enums.InventoryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "inventoryTransactionEntity")
@Table(name = "Inventory_transactions_tbl")

public class InventoryTransaction extends Base {

    @Id
    @SequenceGenerator(name = "inventory_t_seq", sequenceName = "inventory_t_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_t_seq")
    @JsonProperty("ردیف")
    private Long id;


    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name=("inventory_product"), foreignKey = @ForeignKey(name="fk-Transaction_inventory_p"))
    @JsonProperty("کالا های انبار")
    private InventoryProduct inventoryProduct;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name=("order_item"), foreignKey = @ForeignKey(name="fk-Trans_inventory_order"))
    @JsonProperty("فاکتور")
    private OrderItem orderItem;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name=("product"), foreignKey = @ForeignKey(name="fk-Trans_inventory_product"))
    @JsonProperty("کالا")
    private Product product;

    @NotNull(message = "تعداد را وارد نکرده اید!!")
    @Column(name = "count", length = 10)
    @JsonProperty("تعداد")
    private Double count;

    @Enumerated(EnumType.ORDINAL)
    private InventoryStatus status;

}
