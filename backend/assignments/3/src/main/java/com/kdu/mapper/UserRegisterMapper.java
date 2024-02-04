package com.kdu.mapper;

import com.kdu.model.dto.request.UserRegisterRequestDTO;
import com.kdu.model.entity.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper {


    PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegisterMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public UserRegister userMapping(UserRegisterRequestDTO userRegisterRequestDTO){
        UserRegister userRegister = new UserRegister();
        userRegister.setUsername(userRegisterRequestDTO.getUsername());
        userRegister.setFirstName(userRegisterRequestDTO.getFirstName());
        userRegister.setLastName(userRegisterRequestDTO.getLastName());
        userRegister.setEmail(userRegisterRequestDTO.getEmail());
        userRegister.setName(userRegisterRequestDTO.getName());
        userRegister.setPassword(passwordEncoder.encode(userRegisterRequestDTO.getPassword()));

        return userRegister;
    }
}
