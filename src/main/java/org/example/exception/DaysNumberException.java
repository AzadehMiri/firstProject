package org.example.exception;

public class DaysNumberException extends Exception {
    public DaysNumberException(String message) {
        super("Negative or zero DurationDays: " + message + " !!!");
    }
}
