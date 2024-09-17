package com.example.springsecurityassignment.exception;


import com.example.springsecurityassignment.dto.ErrorDto;
import com.example.springsecurityassignment.exception.custom.NoUserFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleNoUserFoundException(NoUserFoundException exception) {
        return new ResponseEntity<>(new ErrorDto(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(Exception exception) {
        return new ResponseEntity<>(new ErrorDto(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
