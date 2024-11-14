package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.service.BankService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/test/banks")
public class TestApiAli {

    @Inject
    private BankService bankService;

    @GET
    public String testBankApi() {
        log.info("Testing Bank API");

        // Step 1: Create a new Bank entity
        Bank bank = Bank.builder()
                .name("Test Bank")
                .accountNumber("12345678")
                .build();
        bankService.save(bank);
        log.info("Bank created: " + bank);

        // Step 2: Update the bank entity
        bank.setName("Updated Test Bank");
        bankService.edit(bank);
        log.info("Bank updated: " + bank);

        // Step 3: Retrieve the updated bank entity by ID
        Bank retrievedBank = bankService.findById(bank.getId());
        log.info("Retrieved Bank: " + retrievedBank);

        return retrievedBank.toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankById(@PathParam("id") Long id) {
        try {
            Bank bank = bankService.findById(id);
            if (bank == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Bank not found").build();
            }
            return Response.ok(bank).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBank(Bank bank) {
        try {
            bankService.edit(bank);
            return Response.ok(bank).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
