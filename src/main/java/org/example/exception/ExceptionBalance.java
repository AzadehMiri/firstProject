package org.example.exception;

public class ExceptionBalance extends Exception {
    public ExceptionBalance(String message) {
        super("Negative balance: " + message);
    }
}
