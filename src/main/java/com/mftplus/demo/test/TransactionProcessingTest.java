package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.*;

public class TransactionProcessingTest {

    public static void main(String[] args) {

        Bank bank = Bank.builder()
                .id(1L)
                .name("Sample Bank")
                .accountNumber("1234567890")
                .build();

        PaymentMethod paymentMethod = PaymentMethod.builder()
                .id(1L)
                .name("Credit Card")
                .build();

        FinancialDoc financialDoc = FinancialDoc.builder()
                .id(1L)
                .name("Invoice")
                .build();

        Transaction transaction = Transaction.builder()
                .id(1L)
                .amount(1000.0)
                .paymentMethod(paymentMethod)
                .bank(bank)
                .financialDoc(financialDoc)
                .build();

        Refund refund = Refund.builder()
                .id(1L)
                .amount(500.0)
                .transaction(transaction)
                .build();

        Report report = Report.builder()
                .id(1L)
                .description("Successful transaction")
                .transaction(transaction)
                .build();

        // تست کلاس Bank
        if (bank != null) {
            if (bank.getId() == 1L) {
                System.out.println("Bank ID is correct.");
            } else {
                System.out.println("Bank ID is incorrect.");
            }

            if (bank.getName().equals("Sample Bank")) {
                System.out.println("Bank Name is correct.");
            } else {
                System.out.println("Bank Name is incorrect.");
            }

            if (bank.getAccountNumber().equals("1234567890")) {
                System.out.println("Bank Account Number is correct.");
            } else {
                System.out.println("Bank Account Number is incorrect.");
            }
        }

        // تست کلاس Transaction
        if (transaction != null) {
            if (transaction.getId() == 1L) {
                System.out.println("Transaction ID is correct.");
            } else {
                System.out.println("Transaction ID is incorrect.");
            }

            if (transaction.getAmount() == 1000.0) {
                System.out.println("Transaction Amount is correct.");
            } else {
                System.out.println("Transaction Amount is incorrect.");
            }

            if (transaction.getPaymentMethod().getName().equals("Credit Card")) {
                System.out.println("Transaction Payment Method is correct.");
            } else {
                System.out.println("Transaction Payment Method is incorrect.");
            }

            if (transaction.getBank().getName().equals("Sample Bank")) {
                System.out.println("Transaction Bank is correct.");
            } else {
                System.out.println("Transaction Bank is incorrect.");
            }

            if (transaction.getFinancialDoc().getName().equals("Invoice")) {
                System.out.println("Transaction FinancialDoc is correct.");
            } else {
                System.out.println("Transaction FinancialDoc is incorrect.");
            }
        }

        // تست کلاس FinancialDoc
        if (financialDoc != null) {
            if (financialDoc.getId() == 1L) {
                System.out.println("FinancialDoc ID is correct.");
            } else {
                System.out.println("FinancialDoc ID is incorrect.");
            }

            if (financialDoc.getName().equals("Invoice")) {
                System.out.println("FinancialDoc Name is correct.");
            } else {
                System.out.println("FinancialDoc Name is incorrect.");
            }
        }

        // تست کلاس PaymentMethod
        if (paymentMethod != null) {
            if (paymentMethod.getId() == 1L) {
                System.out.println("PaymentMethod ID is correct.");
            } else {
                System.out.println("PaymentMethod ID is incorrect.");
            }

            if (paymentMethod.getName().equals("Credit Card")) {
                System.out.println("PaymentMethod Name is correct.");
            } else {
                System.out.println("PaymentMethod Name is incorrect.");
            }
        }

        // تست کلاس Refund
        if (refund != null) {
            if (refund.getId() == 1L) {
                System.out.println("Refund ID is correct.");
            } else {
                System.out.println("Refund ID is incorrect.");
            }

            if (refund.getAmount() == 500.0) {
                System.out.println("Refund Amount is correct.");
            } else {
                System.out.println("Refund Amount is incorrect.");
            }

            if (refund.getTransaction() != null && refund.getTransaction().getId() == 1L) {
                System.out.println("Refund Transaction is correct.");
            } else {
                System.out.println("Refund Transaction is incorrect.");
            }
        }

        // تست کلاس Report
        if (report != null) {
            if (report.getId() == 1L) {
                System.out.println("Report ID is correct.");
            } else {
                System.out.println("Report ID is incorrect.");
            }

            if (report.getDescription().equals("Successful transaction")) {
                System.out.println("Report Description is correct.");
            } else {
                System.out.println("Report Description is incorrect.");
            }

            if (report.getTransaction() != null && report.getTransaction().getId() == 1L) {
                System.out.println("Report Transaction is correct.");
            } else {
                System.out.println("Report Transaction is incorrect.");
            }
        }

//        نمایش کلی

        assert bank != null;
        System.out.println("Bank{id=" + bank.getId() + ", name='" + bank.getName() + "', accountNumber='" + bank.getAccountNumber() + "'}");

        assert paymentMethod != null;
        System.out.println("PaymentMethod{id=" + paymentMethod.getId() + ", name='" + paymentMethod.getName() + "'}");

        assert financialDoc != null;
        System.out.println("FinancialDoc{id=" + financialDoc.getId() + ", name='" + financialDoc.getName() + "'}");

        assert transaction != null;
        System.out.println("Transaction{id=" + transaction.getId() + ", amount=" + transaction.getAmount() +
                ", paymentMethod=" + transaction.getPaymentMethod().getName() +
                ", bank=" + transaction.getBank().getName() +
                ", financialDoc=" + transaction.getFinancialDoc().getName() + "}");

        assert refund != null;
        System.out.println("Refund{id=" + refund.getId() + ", amount=" + refund.getAmount() +
                ", transaction=" + (refund.getTransaction() != null ? "Transaction ID " + refund.getTransaction().getId() : "null") + "}");

        assert report != null;
        System.out.println("Report{id=" + report.getId() + ", description='" + report.getDescription() +
                "', transaction=" + (report.getTransaction() != null ? "Transaction ID " + report.getTransaction().getId() : "null") + "}");
    }
}
