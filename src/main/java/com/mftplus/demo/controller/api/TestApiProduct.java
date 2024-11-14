package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

@Path("/testproduct")
@Slf4j
public class TestApiProduct {

    @Inject
    private ProductService productService;

    @GET

    public String test() {
        log.info("test loaded++");

        Product product = Product.builder().name("shampoo").price(170F).code(111L).build();
        productService.save(product);
        return product.toString();

    }


}
