package com.kdu.caching.exception.custom;

/**
 * Custom exception indicating that the geocoding input is invalid or no data is found in the database.
 * This exception is thrown when the geocoding input is deemed invalid or when no corresponding data is found in the database.
 */
public class InvalidGeocodingInputException extends NullPointerException {
    public InvalidGeocodingInputException(String message) {
        super(message);
    }
}
