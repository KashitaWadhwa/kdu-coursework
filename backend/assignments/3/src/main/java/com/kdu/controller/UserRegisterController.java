package com.kdu.controller;

import com.kdu.model.dto.request.UserRegisterRequestDTO;
import com.kdu.model.dto.response.UserResponseDTO;
import com.kdu.services.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @Autowired
    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }
    @PostMapping("/api/v1/auth/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO){
        UserResponseDTO userResponseDTO = userRegisterService.registerUser(userRegisterRequestDTO);
        return new ResponseEntity<>(userResponseDTO,HttpStatus.OK);
    }
}
