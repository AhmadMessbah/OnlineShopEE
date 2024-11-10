package com.mftplus.demo.test;

import com.mftplus.demo.model.entity.*;
import java.util.Objects;

public class TransactionProcessingTest {

    public static void main(String[] args) {

        // داده‌های مختلف برای کلاس Bank
        Bank[] banks = {
                Bank.builder().id(1L).name("Sample Bank").accountNumber("1234567890").build(),
                Bank.builder().id(2L).name("Another Bank").accountNumber("0987654321").build(),
                Bank.builder().id(-1L).name(null).accountNumber("null").build()  // داده نادرست
        };

        // داده‌های مختلف برای کلاس PaymentMethod
        PaymentMethod[] paymentMethods = {
                PaymentMethod.builder().id(1L).name("Credit Card").build(),
                PaymentMethod.builder().id(2L).name("Debit Card").build(),
                PaymentMethod.builder().id(0L).name("Invalid Payment Method").build()  // داده نادرست
        };

        // داده‌های مختلف برای کلاس FinancialDoc
        FinancialDoc[] financialDocs = {
                FinancialDoc.builder().id(1L).name("Invoice").build(),
                FinancialDoc.builder().id(2L).name("Receipt").build(),
                FinancialDoc.builder().id(-1L).name("").build()  // داده نادرست
        };

        // داده‌های مختلف برای کلاس Transaction
        Transaction[] transactions = {
                Transaction.builder().id(1L).amount(1000.0).paymentMethod(paymentMethods[0]).bank(banks[0]).financialDoc(financialDocs[0]).build(),
                Transaction.builder().id(2L).amount(2000.0).paymentMethod(paymentMethods[1]).bank(banks[1]).financialDoc(financialDocs[1]).build(),
                Transaction.builder().id(0L).amount(-100.0).paymentMethod(paymentMethods[2]).bank(banks[2]).financialDoc(financialDocs[2]).build()  // داده نادرست
        };

        // داده‌های مختلف برای کلاس Refund
        Refund[] refunds = {
                Refund.builder().id(1L).amount(500.0).transaction(transactions[0]).build(),
                Refund.builder().id(2L).amount(1000.0).transaction(transactions[1]).build(),
                Refund.builder().id(0L).amount(-500.0).transaction(transactions[2]).build()  // داده نادرست
        };

        // داده‌های مختلف برای کلاس Report
        Report[] reports = {
                Report.builder().id(1L).description("Successful transaction").transaction(transactions[0]).build(),
                Report.builder().id(2L).description("Failed transaction").transaction(transactions[1]).build(),
                Report.builder().id(0L).description("").transaction(null).build()  // داده نادرست
        };

        // تست کلاس Bank
        for (Bank bank : banks) {
            System.out.println("Testing Bank: " + bank.getName());
            if (bank.getId() > 0) {
                System.out.println("Bank ID is correct.");
            } else {
                System.out.println("Bank ID is incorrect.");
            }
            if (Objects.nonNull(bank.getName()) && !bank.getName().isEmpty()) {
                System.out.println("Bank Name is correct.");
            } else {
                System.out.println("Bank Name is incorrect.");
            }
            if (Objects.nonNull(bank.getAccountNumber()) && !bank.getAccountNumber().isEmpty()) {
                System.out.println("Bank Account Number is correct.");
            } else {
                System.out.println("Bank Account Number is incorrect.");
            }
            System.out.println();
        }

        // تست کلاس PaymentMethod
        for (PaymentMethod paymentMethod : paymentMethods) {
            System.out.println("Testing PaymentMethod: " + paymentMethod.getName());
            if (paymentMethod.getId() > 0) {
                System.out.println("PaymentMethod ID is correct.");
            } else {
                System.out.println("PaymentMethod ID is incorrect.");
            }
            if (Objects.nonNull(paymentMethod.getName()) && !paymentMethod.getName().isEmpty()) {
                System.out.println("PaymentMethod Name is correct.");
            } else {
                System.out.println("PaymentMethod Name is incorrect.");
            }
            System.out.println();
        }

        // تست کلاس FinancialDoc
        for (FinancialDoc financialDoc : financialDocs) {
            System.out.println("Testing FinancialDoc: " + financialDoc.getName());
            if (financialDoc.getId() > 0) {
                System.out.println("FinancialDoc ID is correct.");
            } else {
                System.out.println("FinancialDoc ID is incorrect.");
            }
            if (Objects.nonNull(financialDoc.getName()) && !financialDoc.getName().isEmpty()) {
                System.out.println("FinancialDoc Name is correct.");
            } else {
                System.out.println("FinancialDoc Name is incorrect.");
            }
            System.out.println();
        }

        // تست کلاس Transaction
        for (Transaction transaction : transactions) {
            System.out.println("Testing Transaction ID: " + transaction.getId());
            if (transaction.getId() > 0) {
                System.out.println("Transaction ID is correct.");
            } else {
                System.out.println("Transaction ID is incorrect.");
            }
            if (transaction.getAmount() > 0) {
                System.out.println("Transaction Amount is correct.");
            } else {
                System.out.println("Transaction Amount is incorrect.");
            }
            if (Objects.nonNull(transaction.getPaymentMethod()) && Objects.nonNull(transaction.getPaymentMethod().getName())) {
                System.out.println("Transaction Payment Method is correct.");
            } else {
                System.out.println("Transaction Payment Method is incorrect.");
            }
            if (Objects.nonNull(transaction.getBank()) && Objects.nonNull(transaction.getBank().getName())) {
                System.out.println("Transaction Bank is correct.");
            } else {
                System.out.println("Transaction Bank is incorrect.");
            }
            if (Objects.nonNull(transaction.getFinancialDoc()) && Objects.nonNull(transaction.getFinancialDoc().getName())) {
                System.out.println("Transaction FinancialDoc is correct.");
            } else {
                System.out.println("Transaction FinancialDoc is incorrect.");
            }
            System.out.println();
        }

        // تست کلاس Refund
        for (Refund refund : refunds) {
            System.out.println("Testing Refund ID: " + refund.getId());
            if (refund.getId() > 0) {
                System.out.println("Refund ID is correct.");
            } else {
                System.out.println("Refund ID is incorrect.");
            }
            if (refund.getAmount() > 0) {
                System.out.println("Refund Amount is correct.");
            } else {
                System.out.println("Refund Amount is incorrect.");
            }
            if (Objects.nonNull(refund.getTransaction())) {
                System.out.println("Refund Transaction is correct.");
            } else {
                System.out.println("Refund Transaction is incorrect.");
            }
            System.out.println();
        }

        // تست کلاس Report
        for (Report report : reports) {
            System.out.println("Testing Report ID: " + report.getId());
            if (report.getId() > 0) {
                System.out.println("Report ID is correct.");
            } else {
                System.out.println("Report ID is incorrect.");
            }
            if (Objects.nonNull(report.getDescription()) && !report.getDescription().isEmpty()) {
                System.out.println("Report Description is correct.");
            } else {
                System.out.println("Report Description is incorrect.");
            }
            if (Objects.nonNull(report.getTransaction())) {
                System.out.println("Report Transaction is correct.");
            } else {
                System.out.println("Report Transaction is incorrect.");
            }
            System.out.println();
        }
        // نمایش کلی داده‌ها
        for (Bank bank : banks) {
            System.out.println("Bank{id=" + bank.getId() + ", name='" + bank.getName() + "', accountNumber='" + bank.getAccountNumber() + "'}");
        }

        for (PaymentMethod paymentMethod : paymentMethods) {
            System.out.println("PaymentMethod{id=" + paymentMethod.getId() + ", name='" + paymentMethod.getName() + "'}");
        }

        for (FinancialDoc financialDoc : financialDocs) {
            System.out.println("FinancialDoc{id=" + financialDoc.getId() + ", name='" + financialDoc.getName() + "'}");
        }

        for (Transaction transaction : transactions) {
            System.out.println("Transaction{id=" + transaction.getId() + ", amount=" + transaction.getAmount() +
                    ", paymentMethod=" + transaction.getPaymentMethod().getName() +
                    ", bank=" + transaction.getBank().getName() +
                    ", financialDoc=" + transaction.getFinancialDoc().getName() + "}");
        }

        for (Refund refund : refunds) {
            System.out.println("Refund{id=" + refund.getId() + ", amount=" + refund.getAmount() +
                    ", transaction=" + (refund.getTransaction() != null ? "Transaction ID " + refund.getTransaction().getId() : "null") + "}");
        }

        for (Report report : reports) {
            System.out.println("Report{id=" + report.getId() + ", description='" + report.getDescription() +
                    "', transaction=" + (report.getTransaction() != null ? "Transaction ID " + report.getTransaction().getId() : "null") + "}");
        }
    }
}
