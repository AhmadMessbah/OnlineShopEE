package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.service.InventoryService;
import jakarta.inject.Inject;
import  jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;


@Path("/inventories")
@Slf4j
public class InventoryApi {

    @Inject
    private InventoryService inventoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventories(){
        log.info("Get Inventories Info");
        return Response.ok().entity(inventoryService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getInventoriesById(@PathParam("id") Long id){
        return Response.ok().entity(inventoryService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{title}")
    public Response getInventoriesByTitle(@PathParam("title") String title){
        return Response.ok().entity(inventoryService.findByTitle(title)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{address}")
    public Response getInventoriesByAddress(@PathParam("address") String address){
        return Response.ok().entity(inventoryService.findByAddress(address)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{phone}")
    public Response getInventoriesByPhone(@PathParam("phone") String phone){
        return Response.ok().entity(inventoryService.findByPhone(phone)).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInventory(Inventory inventory){
        inventoryService.save(inventory);
        return Response.ok().entity(inventory).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInventory(Inventory inventory){
        inventoryService.edit(inventory);
        return Response.ok().entity(inventory).build();
    }
    @DELETE
    @Path("{id}")
    public Response removeInventory(@PathParam("id") Long id) {
        inventoryService.remove(id);
        return Response.ok().entity(id).build();
    }
}
