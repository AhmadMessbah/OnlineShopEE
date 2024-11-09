package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.service.TransactionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/transactions")
@Slf4j
public class TransactionApi {

    @Inject
    private TransactionService transactionService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTransactions() {
        log.info("Getting all transactions");
        return Response.ok().entity(transactionService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getTransactionById(@PathParam("id") Integer id) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Transaction not found").build();
        }
        return Response.ok().entity(transaction).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTransaction(Transaction transaction) {
        transactionService.save(transaction);
        return Response.status(Response.Status.CREATED).entity(transaction).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTransaction(Transaction transaction) {
        transactionService.edit(transaction);
        return Response.ok().entity(transaction).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTransaction(@PathParam("id") Integer id) {
        transactionService.remove(id);
        return Response.ok().entity(id).build();
    }
}
