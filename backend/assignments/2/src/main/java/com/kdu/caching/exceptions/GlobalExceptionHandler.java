package com.kdu.caching.exceptions;

import com.kdu.caching.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global exception handler for handling exceptions across the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles GeocodingException and its subclasses.
     *
     * @param ex the exception to handle.
     * @return ResponseEntity with error details.
     */
    @ExceptionHandler(GeocodingException.class)
    public ResponseEntity<ErrorDTO> handleGeocodingException(GeocodingException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CacheErrorException.class)
    public ResponseEntity<ErrorDTO> handleCacheErrorException(CacheErrorException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidGeocodingInputException.class)
    public ResponseEntity<ErrorDTO> handleInvalidGeocodingInputException(InvalidGeocodingInputException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ReverseGeocodingFailureException.class)
    public ResponseEntity<ErrorDTO> handleReverseGeocodingFailureException(ReverseGeocodingFailureException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }


    /**
     * Handles generic exceptions that do not have a specific handler.
     *
     * @param ex the exception to handle.
     * @return ResponseEntity with error details.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDTO> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
