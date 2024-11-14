package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.entity.InventoryTransaction;
import com.mftplus.demo.model.service.InventoryTransactionService;
import jakarta.inject.Inject;
import  jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/inventoryTransaction")
@Slf4j
public class InventoryTransactionApi {

    @Inject
    private InventoryTransactionService inventoryTransactionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryTransaction(){
        log.info("Get Inventories' Transactions Info");
        return Response.ok().entity(inventoryTransactionService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getInventoryTransactionById(@PathParam("id") Long id){
        return Response.ok().entity(inventoryTransactionService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/inventory/{inventory}")
    public Response getInventoryTransactionByInventory(@PathParam("inventory") Long id){
        log.info("get inventory id");
        return Response.ok().entity(inventoryTransactionService.findByInventoryId(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/product/{product}")
    public Response getInventoryTransactionByProduct(@PathParam("product") Long id){
        return Response.ok().entity(inventoryTransactionService.findByProductId(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/order/{order}")
    public Response getInventoryTransactionByOrder(@PathParam("order") Long id){
        return Response.ok().entity(inventoryTransactionService.findByOrderId(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInventoryTransaction(InventoryTransaction inventoryTransaction){
        inventoryTransactionService.save(inventoryTransaction);
        return Response.ok().entity(inventoryTransaction).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInventoryTransaction(InventoryTransaction inventoryTransaction){
        inventoryTransactionService.edit(inventoryTransaction);
        return Response.ok().entity(inventoryTransaction).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeInventoryTransaction(@PathParam("id") Long id) {
        inventoryTransactionService.remove(id);
        return Response.ok().entity(id).build();
    }
}
