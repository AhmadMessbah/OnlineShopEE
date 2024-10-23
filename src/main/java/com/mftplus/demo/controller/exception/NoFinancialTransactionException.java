package com.mftplus.demo.controller.exception;

public class NoFinancialTransactionException extends Exception {
    public NoFinancialTransactionException() {
        super("No financial transaction found");
    }
}
