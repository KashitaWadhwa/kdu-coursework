package org.example.exceptions;

public class NotBlankException extends RuntimeException {
    public NotBlankException(String message) {
        super(message);
    }
}
