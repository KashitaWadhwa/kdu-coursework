package com.kdu.myapplication.exception.custom;

public class InvalidAuthException extends IndexOutOfBoundsException {
    public InvalidAuthException(String s) {
        super(s);
    }

}
