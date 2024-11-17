package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.PaymentMethod;
import com.mftplus.demo.model.service.PaymentMethodService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/paymentMethods")
@Slf4j
public class PaymentMethodApi {

    @Inject
    private PaymentMethodService paymentMethodService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPaymentMethods() {
        log.info("Getting all payment methods");
        return Response.ok().entity(paymentMethodService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getPaymentMethodById(@PathParam("id") Long id) {
        PaymentMethod paymentMethod = paymentMethodService.findById(id);
        if (paymentMethod == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Payment Method not found").build();
        }
        return Response.ok().entity(paymentMethod).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodService.save(paymentMethod);
        return Response.status(Response.Status.CREATED).entity(paymentMethod).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodService.edit(paymentMethod);
        return Response.ok().entity(paymentMethod).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePaymentMethod(@PathParam("id") Long id) {
        paymentMethodService.remove(id);
        return Response.ok().entity(id).build();
    }
}
