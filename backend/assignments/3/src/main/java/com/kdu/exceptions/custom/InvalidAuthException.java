package com.kdu.exceptions.custom;

public class InvalidAuthException extends IndexOutOfBoundsException {
    public InvalidAuthException(String s) {
        super(s);
    }

}
