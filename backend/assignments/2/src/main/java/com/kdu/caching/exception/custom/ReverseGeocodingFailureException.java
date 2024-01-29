package com.kdu.caching.exception.custom;

public class ReverseGeocodingFailureException extends IllegalArgumentException {

    /**
     * Constructs a ReverseGeocodingFailureException with the  message.
     *
     * @param message
     */
    public ReverseGeocodingFailureException(String message) {
        super(message);
    }
}
