package com.kdu.caching.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a cache operation related to geocoding fails.
 */
public class CacheErrorException extends RuntimeException {

    /**
     * Constructs a new CacheErrorException with the specified action.
     *
     * @param action the cache operation that resulted in an error.
     */
    public CacheErrorException(String action) {
        super("Cache error during " + action + " operation.");
    }
}
