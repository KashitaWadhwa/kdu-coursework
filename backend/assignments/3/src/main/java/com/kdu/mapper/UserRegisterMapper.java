package com.kdu.mapper;

import com.kdu.model.dto.request.UserRegisterRequestDTO;
import com.kdu.model.entity.UserModel;
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


    public UserModel userMapping(UserRegisterRequestDTO userRegisterRequestDTO){
        UserModel userModel = new UserModel();
        userModel.setUsername(userRegisterRequestDTO.getUsername());
        userModel.setFirstName(userRegisterRequestDTO.getFirstName());
        userModel.setLastName(userRegisterRequestDTO.getLastName());
        userModel.setEmail(userRegisterRequestDTO.getEmail());
        userModel.setName(userRegisterRequestDTO.getName());
        userModel.setPassword(passwordEncoder.encode(userRegisterRequestDTO.getPassword()));

        return userModel;
    }
}
