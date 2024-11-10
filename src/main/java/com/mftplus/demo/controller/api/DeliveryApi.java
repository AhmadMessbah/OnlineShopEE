package com.mftplus.demo.controller.api;


import com.mftplus.demo.model.entity.Delivery;
import com.mftplus.demo.model.entity.Refund;
import com.mftplus.demo.model.service.DeliveryService;
import com.mftplus.demo.model.service.RefundService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/delivery")
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
    public Response getfindById(@PathParam("id") Integer id) {
        Delivery delivery = deliveryService.findById(id);
        if (delivery == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Refund not found").build();
        }
        return Response.ok().entity(delivery).build();
    }
}
