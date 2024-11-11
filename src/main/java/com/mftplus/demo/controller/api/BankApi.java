package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.service.BankService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/banks")
@Slf4j
public class BankApi {

    @Inject
    private BankService bankService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBanks() {
        log.info("Getting all banks");
        return Response.ok().entity(bankService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getBankById(@PathParam("id") Long id) {
        Bank bank = bankService.findById(id);
        if (bank == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Bank not found").build();
        }
        return Response.ok().entity(bank).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBank(Bank bank) {
        bankService.save(bank);
        return Response.status(Response.Status.CREATED).entity(bank).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBank(Bank bank) {
        bankService.edit(bank);
        return Response.ok().entity(bank).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBank(@PathParam("id") Long id) {
        bankService.remove(id);
        return Response.ok().entity(id).build();
    }
}
