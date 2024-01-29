package com.kdu.caching.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for geocoding-related errors.
 */
public class GeocodingException extends RuntimeException {

    /**
     * Constructs a new GeocodingException with the specified detail message.
     *
     * @param message the detail message.
     */
    public GeocodingException(String message) {
        super(message);
    }
}




