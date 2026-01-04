package com.example.ceramics.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String email) {
        super("Customer with email " + email + " already exists");
    }
}
