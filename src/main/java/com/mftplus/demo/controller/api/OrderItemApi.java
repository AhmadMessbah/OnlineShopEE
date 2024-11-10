package com.mftplus.demo.controller.api;


import com.mftplus.demo.model.entity.OrderItem;
import com.mftplus.demo.model.service.OrderItemService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/orderItems")
@Slf4j
public class OrderItemApi {
    @Inject
    private OrderItemService orderItemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrderItems() {
        log.info("Getting all Order Items");
        return Response.ok().entity(orderItemService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getOrderItemById(@PathParam("id") Long id) {
        OrderItem orderItem = orderItemService.findById(id);
        if (orderItem == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Order Items not found").build();
        }
        return Response.ok().entity(orderItem).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrderItems(OrderItem orderItem) {
        orderItemService.save(orderItem);
        return Response.status(Response.Status.CREATED).entity(orderItem).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrderItems(OrderItem orderItem) {
        orderItemService.edit(orderItem);
        return Response.ok().entity(orderItem).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteOrderItems(@PathParam("id") Long id) {
        orderItemService.remove(id);
        return Response.ok().entity(id).build();
    }


}
