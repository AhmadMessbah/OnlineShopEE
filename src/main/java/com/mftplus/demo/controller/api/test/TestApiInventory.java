package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.entity.InventoryProduct;
import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.service.InventoryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/test_inventory")
public class TestApiInventory {

    @Inject
    private InventoryService inventoryService;


    @GET
    public String test() {
        log.info("test get inventories");
        InventoryProduct inventoryProduct = InventoryProduct.builder().quantity(52D).build();
        Inventory inventory = Inventory.builder().title("OOOO").phone("8888").address("NNNN").inventoryProduct(inventoryProduct).build();
        Product product = Product.builder().name("LLLL").code(897L).build();
        inventoryService.save(inventory);
        return inventoryService.findAll().toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String testGetInventoryById(@PathParam("id") Long id) {
        log.info("test get inventories by id", id);
        Inventory inventory = inventoryService.findById(id);
        return inventory.toString();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/title/{title}")
//    public String testGetInventoriesByTitle(@PathParam("title") String title) {
//        log.info("test get inventories by title", title);
//        Inventory inventory = (Inventory) inventoryService.findByTitle(title);
//        return inventory.toString();
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/address/{address}")
//    public String testGetInventoriesByAddress(@PathParam("address") String address) {
//        log.info("test get inventories by address", address);
//        Inventory inventory = (Inventory) inventoryService.findByAddress(address);
//        return inventory.toString();
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/phone/{phone}")
//    public String testGetInventoriesByPhone(@PathParam("phone") String phone) {
//        log.info("test get inventories by phone", phone);
//        Inventory inventory = (Inventory) inventoryService.findByPhone(phone);
//        return inventory.toString();
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/InventoryProduct/{InventoryProduct}")
//    public String testGetInventoriesByInventoryProductId(@PathParam("InventoryProduct") Long id) {
//        log.info("test get inventories by inventory iroduct id", id);
//        Inventory inventory = (Inventory) inventoryService.findByInventoryProductId(id);
//        return inventory.toString();
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/product/{product}")
//    public String testGetInventoriesByByProductName(@PathParam("product") String name) {
//        log.info("test get inventories by product name", name);
//        Inventory inventory = (Inventory) inventoryService.findByProductName(name);
//        return inventory.toString();
    }


