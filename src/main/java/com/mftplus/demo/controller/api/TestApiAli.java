package com.mftplus.demo.controller.api;

import com.mftplus.demo.model.entity.*;
import com.mftplus.demo.model.service.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path("/testt")
public class TestApiAli {

    @Inject
    private TransactionService transactionService;

    //    @Inject
//    private FinancialDocService financialDocService;
//
//
//    @Inject
//    private BankService bankService;
//
//    @Inject
//    private RefundService refundService;

//    @GET
//    public String testBankApi() {
//        log.info("Testing Bank API");
//
//        // Step 1: Create a new Bank entity
//        Bank bank = Bank.builder()
//                .name("Test Bank")
//                .accountNumber("12345678")
//                .build();
//        bankService.save(bank);
//        log.info("Bank created: " + bank);
//
//        // Step 2: Update the bank entity
//        bank.setName("Updated Test Bank");
//        bankService.edit(bank);
//        log.info("Bank updated: " + bank);
//
//        // Step 3: Retrieve the updated bank entity by ID
//        Bank retrievedBank = bankService.findById(bank.getId());
//        log.info("Retrieved Bank: " + retrievedBank);
//
//        return retrievedBank.toString();
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getBankById(@PathParam("id") Long id) {
//        try {
//            Bank bank = bankService.findById(id);
//            if (bank == null) {
//                return Response.status(Response.Status.NOT_FOUND).entity("Bank not found").build();
//            }
//            return Response.ok(bank).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateBank(Bank bank) {
//        try {
//            bankService.edit(bank);
//            return Response.ok(bank).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
//        }
//    }


//
//    @GET
//    public String testAliApi(){
//
//        Bank bank = Bank.builder()
//                .name("Test Bank")
//                .accountNumber("12345678")
//                .build();
//
//        Transaction transaction = Transaction.builder().amount(852d).bank(bank).build();
//
//        FinancialDoc financialDoc = FinancialDoc.builder()
//                .name("HHH")
////                .transactions(List.of(transaction))
//                .build();
//        financialDocService.save(financialDoc);
//        return financialDoc.toString();
//    }

//
//    @GET
//    public String testAliApi(){
//
//
//        Bank bank = Bank.builder()
//                .name("Test Bank")
//                .accountNumber("12345678")
//                .build();
//        bankService.save(bank);
//
//        Refund refund = Refund.builder().amount(587d).build();
//        refundService.save(refund);
//
//        FinancialDoc financialDoc = FinancialDoc.builder().name("HeH").build();
//        financialDocService.save(financialDoc);
//
//        Transaction transaction=Transaction
//                .builder().amount(545d).bank(bank).refund(refund).financialDoc(financialDoc).build();
//        transactionService.save(transaction);
//        return transaction.toString();
//    }

//      @Inject
//    private RefundService refundService;
//      @GET
//      public String testAliApi() {
//
//          Transaction transaction = Transaction.builder().amount(545d).build();
//          transactionService.save(transaction);
//
//          Refund refund = Refund.builder().amount(569d).build();
//          refundService.save(refund);
//
//          return refund.toString();}

//    @Inject
//    private PaymentMethodService paymentMethodService;
//    @GET
//
//    public String testAliApi(){
//
////        Transaction transaction = Transaction.builder().amount(545d).build();
////        transactionService.save(transaction);
//
//          PaymentMethod paymentMethod = PaymentMethod
//                  .builder().name("pay").build();
//          paymentMethodService.save(paymentMethod);
//          return paymentMethod.toString();
//    }

//    @Inject
//    private ReportService reportService;
//    @GET
//
//    public String test()
//    {
////        Transaction transaction = Transaction.builder().amount(545d).build();
////        transactionService.save(transaction);
//        Report report = Report .builder().description("yyy").build();
//        reportService.save(report);
//        return report.toString();
//    }

}
