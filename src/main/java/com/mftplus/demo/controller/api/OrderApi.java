package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Order;
import com.mftplus.demo.model.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/orders")
@Slf4j
public class OrderApi {
    @Inject
    private OrderService orderService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getOrderById(@PathParam("id") Long id) {
        return Response.ok().entity(orderService.findById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(Order order) {
        orderService.save(order);
        return Response.status(Response.Status.CREATED).entity(order).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(Order order) {
        orderService.edit(order);
        return Response.ok().entity(order).build();
    }
    @DELETE
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") Long id) {
        orderService.remove(id);
        return Response.ok().entity(id).build();
    }
}
