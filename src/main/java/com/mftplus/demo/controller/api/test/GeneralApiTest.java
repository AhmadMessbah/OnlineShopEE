package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.Bank;
import com.mftplus.demo.model.entity.Payment;
import com.mftplus.demo.model.entity.Transaction;
import com.mftplus.demo.model.service.BankService;
import com.mftplus.demo.model.service.PaymentService;
import com.mftplus.demo.model.service.TransactionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Path("/general_test")
public class GeneralApiTest {

    @Inject
    private BankService bankService;

    @Inject
    private PaymentService paymentService;

    @Inject
    private TransactionService transactionService;

    @GET
    @Path("/test_all")
    public String testAll() {
        log.info("Testing all APIs");

        // Test Bank API
        Bank bank = Bank.builder()
                .name("General Test Bank")
                .accountNumber("1234567890")
                .branchCode(111L)
                .build();
        bankService.save(bank);
        log.info("Bank created: {}", bank);

        // Test Payment API
        Payment payment = Payment.builder()
                .docNumber(98765L)
                .date(LocalDate.now())
                .description("General Test Payment")
                .build();
        paymentService.save(payment);
        log.info("Payment created: {}", payment);

        // Test Transaction API
        Transaction transaction = Transaction.builder()
                .trackingCode(1122334455L)
                .date(LocalDate.now())
                .build();
        transactionService.save(transaction);
        log.info("Transaction created: {}", transaction);

        return "All APIs tested successfully!";
    }

    @GET
    @Path("/bank/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBankById(@PathParam("id") Long id) {
        return Response.ok(bankService.findById(id)).build();
    }

    @GET
    @Path("/payment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentById(@PathParam("id") Long id) {
        return Response.ok(paymentService.findById(id)).build();
    }

    @GET
    @Path("/transaction/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransactionById(@PathParam("id") Long id) {
        return Response.ok(transactionService.findById(id)).build();
    }

    @PUT
    @Path("/update_bank")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBank(Bank bank) {
        bank.setBranchCode(222L);
        bankService.edit(bank);
        return Response.ok(bank).build();
    }

    @PUT
    @Path("/update_payment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePayment(Payment payment) {
        payment.setDescription("Updated General Payment");
        paymentService.edit(payment);
        return Response.ok(payment).build();
    }

    @PUT
    @Path("/update_transaction")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTransaction(Transaction transaction) {
        transaction.setTrackingCode(5566778899L);
        transactionService.edit(transaction);
        return Response.ok(transaction).build();
    }
}
