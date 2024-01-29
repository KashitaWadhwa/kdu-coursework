package com.kdu.caching.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a reverse geocoding operation fails.
 */
public class ReverseGeocodingFailureException extends RuntimeException {

    /**
     * Constructs a new ReverseGeocodingFailureException with the specified cause.
     *
     */
    public ReverseGeocodingFailureException(String msg) {
        super("Failed to retrieve reverse geocoding information. Reason: " + msg);
    }
}
