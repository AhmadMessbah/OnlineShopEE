package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "inventory_product")
@Table(name = "inventory_product_tbl")
public class InventoryProduct extends Base{

    @Id
    @SequenceGenerator(name = "inventory_product_seq", sequenceName = "inventory_product_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_product_seq")
    @JsonProperty("ردیف")
    private Long id;

    @Column(name = "quantity")
    @JsonProperty("تعداد کالا")
    @NotNull(message = "تعداد کالا را وارد نکرده اید!!")
    private Double quantity;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "product", foreignKey = @ForeignKey(name="fk-product"))
    @JsonProperty("کالا")
//    @NotNull(message = "کالا را وارد نکرده اید!!")
    private Product product;



}
