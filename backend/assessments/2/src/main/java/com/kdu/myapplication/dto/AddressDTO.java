package com.kdu.myapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private String nickName;

    private String street;

    private String city;

    private String state;

    private int postalCode;
}
