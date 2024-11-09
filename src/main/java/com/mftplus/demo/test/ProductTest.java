package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.entity.ProductGroup;


import java.util.List;

public class ProductTest {
    public static void main(String[] args) {
        Product product = Product.builder().name("shampoo badan active").price(2F).build();
        ProductGroup group = ProductGroup.builder().child("shampoo").parent("behdashti").name("badan").build();

    }
}
