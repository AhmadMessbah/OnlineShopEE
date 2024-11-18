package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Path("/payments")
@Slf4j
public class PaymentApi {

    @Inject
    private PaymentService paymentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayments() {
        log.info("get payments");
        return Response.ok().entity(paymentService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getPaymentById(@PathParam("id") Long id) {
        return Response.ok().entity(paymentService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/date/{date}")
    public Response getPaymentsByDate(@PathParam("date") String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return Response.ok().entity(paymentService.findByDate(parsedDate)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPayment(@Valid Payment payment) {
        paymentService.save(payment);
        return Response.ok().entity(payment).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(@Valid Payment payment) {
        paymentService.edit(payment);
        return Response.ok().entity(payment).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePayment(@PathParam("id") Long id) {
        paymentService.remove(id);
        return Response.ok().entity(id).build();
    }
}
