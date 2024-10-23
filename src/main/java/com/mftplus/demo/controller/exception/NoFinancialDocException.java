package com.mftplus.demo.controller.exception;

public class NoFinancialDocException extends Exception {
    public NoFinancialDocException() {
        super("No financial document found");
    }
}
