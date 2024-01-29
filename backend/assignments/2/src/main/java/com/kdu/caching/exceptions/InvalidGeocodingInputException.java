package com.kdu.caching.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an invalid geocoding input is detected.
 */
public class InvalidGeocodingInputException extends RuntimeException {

    /**
     * Constructs a new InvalidGeocodingInputException with the specified input.
     *
     * @param input the invalid geocoding input.
     */
    public InvalidGeocodingInputException(String input) {
        super("Invalid geocoding input: " + input);
    }
}