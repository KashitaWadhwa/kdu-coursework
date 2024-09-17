package com.kdu.caching.exception;

import com.kdu.caching.dto.ErrorDto;
import com.kdu.caching.exception.custom.ReverseGeocodingFailureException;
import com.kdu.caching.exception.custom.InvalidGeocodingInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * CustomExceptionHandler class is a class that handles all the exceptions thrown by the application.
 * It is annotated with @ControllerAdvice to make it a global exception handler.
 * It has methods that handle all the custom exceptions thrown by the application.
 * It returns an ErrorDto object with the error message and the status code.
 * The status code is set according to the type of exception.
 */
@ControllerAdvice
public class CustomExceptionHandler extends Exception{

    /**
     * @param exception NoDataFoundException object that is thrown when no data is found for the given query.
     * @return ResponseEntity object with the ErrorDto object and the status code.
     */
    @ExceptionHandler(value = {InvalidGeocodingInputException.class})
    public ResponseEntity<ErrorDto> handleNoDataFoundException(InvalidGeocodingInputException exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    /**
     * @param exception InvalidCoordinatesException object that is thrown when the coordinates are invalid.
     * The coordinates must be in the valid range of latitude,longitude.
     * @return ResponseEntity object with the ErrorDto object and the status code.
     */
    @ExceptionHandler(value = {ReverseGeocodingFailureException.class})
    public ResponseEntity<ErrorDto> handleInvalidCoordinatesException(ReverseGeocodingFailureException exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param exception Exception object that is thrown when any other exception occurs.
     * @return ResponseEntity object with the ErrorDto object and the status code.
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDto> handleAllOtherExceptions(Exception exception) {
        ErrorDto errorDto = new ErrorDto(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
