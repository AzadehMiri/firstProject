package org.example.exception;

public class DepositTypeException extends Exception {
    public DepositTypeException(String message) {
        super("Unexpected deposit value: " + message);
    }
}
