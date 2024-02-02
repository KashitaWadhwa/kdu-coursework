package com.kdu.myapplication.dto;

import com.kdu.myapplication.entity.Address;
import lombok.Data;

import java.util.List;

@Data

public class UserDTO {

    private String name;
    private String email;
    private String password;
    private List<AddressDTO> nickName;

    private String jwtToken;
}
