package com.kdu.jpa.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UsersDTO {

    private String username;
    private int loggedIn;
    private String timeZone;

}