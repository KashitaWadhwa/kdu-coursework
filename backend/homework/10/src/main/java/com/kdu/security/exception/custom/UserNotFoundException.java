// UserNotFoundException.java
package com.kdu.security.exception.custom;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("User not found with username: " + username);
    }
}
