package com.mftplus.demo.model.entity;
import com.google.gson.Gson;
import com.mftplus.demo.model.entity.enums.InventoryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class InventoryTransaction {

    private Long id;
    private Inventory inventory;
//    private Product product;
//    private Order order;
    private int count;
    private InventoryStatus status;

    @Override
    public String toString() {
        return new Gson().toJson(this);}
}
