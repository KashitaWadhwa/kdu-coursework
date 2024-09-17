package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object for Error Response Body in case of Exception occurs in Controller Layer of the application.
 */
@Data
@AllArgsConstructor
public class ErrorDto {
    private String message;
    private int code;
}
