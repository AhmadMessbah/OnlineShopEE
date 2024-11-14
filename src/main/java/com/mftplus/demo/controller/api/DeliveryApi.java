package com.mftplus.demo.controller.api;


import com.mftplus.demo.model.entity.Delivery;
import com.mftplus.demo.model.service.DeliveryService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/deliveries")
@Slf4j
public class DeliveryApi {

    @Inject
    private DeliveryService deliveryService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDelivery() {
        log.info("Getting all Deliveries");
        return Response.ok().entity(deliveryService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getDeliveryById(@PathParam("id") Long id) {
        Delivery delivery = deliveryService.findById(id);
//        return Response.status(Response.Status.NOT_FOUND).entity("Refund not found").build();
        return  Response.ok().entity(deliveryService.findById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addDelivery(@Valid Delivery delivery) {
        deliveryService.save(delivery);
        return Response.ok().entity(delivery).build();
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDelivery(@Valid Delivery delivery) {
        deliveryService.edit(delivery);
        return Response.ok().entity(delivery).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteDelivery(@PathParam("id") Long id) {
        deliveryService.remove(id);
        return Response.ok().entity(id).build();
    }
}
