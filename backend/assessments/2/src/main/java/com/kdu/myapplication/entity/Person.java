package com.kdu.myapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private String adminName;

    private String userName;

    private String password;

    private String role;
}
