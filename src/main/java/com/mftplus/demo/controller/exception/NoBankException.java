package com.mftplus.demo.controller.exception;

public class NoBankException extends Exception {
    public NoBankException() {
        super("No bank found");
    }
}
