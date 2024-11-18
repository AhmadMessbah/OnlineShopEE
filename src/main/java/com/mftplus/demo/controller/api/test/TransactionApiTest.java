package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.service.TransactionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Path("/transaction_test")
public class TransactionApiTest {

    @Inject
    private TransactionService transactionService;

    @GET
    public String test() {
        log.info("Testing Transaction API");
        Transaction transaction = Transaction.builder()
                .trackingCode(987654321L)
                .date(LocalDate.now())
                .build();
        transactionService.save(transaction);

        transaction.setTrackingCode(123456789L);
        transactionService.edit(transaction);

        return transaction.toString();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateTransaction(Transaction transaction) {
        transaction.setTrackingCode(555555555L);
        transactionService.edit(transaction);
        return transaction.toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransaction(@PathParam("id") Long id) {
        return Response.ok(transactionService.findById(id)).build();
    }

    @GET
    @Path("/tracking/{trackingCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionByTrackingCode(@PathParam("trackingCode") Long trackingCode) {
        try {
            return Response.ok(transactionService.findByTrackingCode(trackingCode)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
