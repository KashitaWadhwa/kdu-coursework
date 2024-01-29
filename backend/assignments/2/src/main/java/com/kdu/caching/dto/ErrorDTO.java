package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Data Transfer Object (DTO) for representing errors in the API responses.
 */
@Data
public class ErrorDTO {

    String message;
    HttpStatus statusCode;

    public ErrorDTO(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Error{" +
                "\n    message='" + message + '\'' +
                ",\n    statusCode=" + statusCode +
                '\n' +
                '}';
    }
}
