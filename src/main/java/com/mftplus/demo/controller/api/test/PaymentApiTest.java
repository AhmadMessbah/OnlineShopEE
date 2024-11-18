package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Path("/payment_test")
public class PaymentApiTest {

    @Inject
    private PaymentService paymentService;

    @GET
    public String test() {
        log.info("Testing Payment API");
        Payment payment = Payment.builder()
                .docNumber(12345L)
                .date(LocalDate.now())
                .description("Test Payment")
                .build();
        paymentService.save(payment);

        payment.setDescription("Updated Payment");
        paymentService.edit(payment);

        return payment.toString();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePayment(Payment payment) {
        payment.setDescription("Modified Payment Description");
        paymentService.edit(payment);
        return payment.toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPayment(@PathParam("id") Long id) {
        return Response.ok(paymentService.findById(id)).build();
    }

    @GET
    @Path("/date/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentsByDate(@PathParam("date") String date) {
        try {
            return Response.ok(paymentService.findByDate(LocalDate.parse(date))).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
