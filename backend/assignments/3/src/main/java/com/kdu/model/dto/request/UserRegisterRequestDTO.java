package com.kdu.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterRequestDTO {
    private String username;

    private String password;

    private String role;

    private String name;

    private String firstName;

    private String lastName;

    private String email;
}
