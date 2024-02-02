package com.kdu.myapplication.exception;

import com.kdu.myapplication.dto.ErrorDTO;
import com.kdu.myapplication.exception.custom.InvalidAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {InvalidAuthException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(InvalidAuthException ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [MyCustomException]", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> allKindOfExceptions(Exception ex){
        ErrorDTO error = new ErrorDTO(ex.getMessage() + " [Parent Exception]", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
