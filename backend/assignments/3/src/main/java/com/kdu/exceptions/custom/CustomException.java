package com.kdu.exceptions.custom;

public class CustomException extends IndexOutOfBoundsException{
    public CustomException(String message){
        super(message);
    }
}