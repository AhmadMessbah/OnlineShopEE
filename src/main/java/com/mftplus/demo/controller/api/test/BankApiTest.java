package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.service.BankService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/bank_test")
public class BankApiTest {

    @Inject
    private BankService bankService;

    @GET
    public String test() {
        log.info("Testing Bank API");
        Bank bank = Bank.builder()
                .name("Test Bank")
                .accountNumber("1234567890")
                .branchCode(101L)
                .build();
        bankService.save(bank);

        bank.setBranchCode(202L);
        bankService.edit(bank);

        return bank.toString();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateBank(Bank bank) {
        bank.setBranchCode(303L);
        bankService.edit(bank);
        return bank.toString();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBank(@PathParam("id") Long id) {
        return Response.ok(bankService.findById(id)).build();
    }

    @GET
    @Path("/account/{accountNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankByAccountNumber(@PathParam("accountNumber") String accountNumber) {
        try {
            return Response.ok(bankService.findByAccountNumber(accountNumber)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
