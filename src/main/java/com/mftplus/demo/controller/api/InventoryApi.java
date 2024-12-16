package com.mftplus.demo.controller.api;

import com.mftplus.demo.controller.interceptor.annotation.ResponseMaker;
import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.service.InventoryService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import  jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;


@Path("/inventories")
@Slf4j
public class InventoryApi {

    @Inject
    private InventoryService inventoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORIES")
    public Object getInventories(){
        log.info("Get Inventories Info");
        return inventoryService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORIES_BY_ID")
    @Path("{id}")
    public Object getInventoriesById(@PathParam("id") Long id){
        return inventoryService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORIES_BY_TITLE")
    @Path("/title/{title}")
    public Object getInventoriesByTitle(@PathParam("title") String title){
        return inventoryService.findByTitle(title);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORIES_BY_ADDRESS")
    @Path("/address/{address}")
    public Object getInventoriesByAddress(@PathParam("address") String address){
        return inventoryService.findByAddress(address);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORIES_BY_PHONE")
    @Path("/phone/{phone}")
    public Object getInventoriesByPhone(@PathParam("phone") String phone){
        return inventoryService.findByPhone(phone);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORIES_BY_PRODUCT_ID")
    @Path("/InventoryProduct/{InventoryProduct}")
    public Object getInventoryByInventoryProductId(@PathParam("InventoryProduct") Long id){
        return inventoryService.findByInventoryProductId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "GET_INVENTORIES_BY_PRODUCT_NAME")
    @Path("/product/{product}")
    public Object getInventoryByProductName(@PathParam("product") String name){
        return inventoryService.findByProductName(name);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "SAVE_INVENTORY")
    public Object addInventory(@Valid Inventory inventory){
        inventoryService.save(inventory);
        return inventory;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseMaker(authority = "EDIT_INVENTORY")
    public Object updateInventory(@Valid Inventory inventory){
        inventoryService.edit(inventory);
        return inventory;
    }
    @DELETE
    @Path("{id}")
    @ResponseMaker(authority = "DELETE_INVENTORY")
    public Object removeInventory(@PathParam("id") Long id) {
        inventoryService.remove(id);
        return id;
    }
}
