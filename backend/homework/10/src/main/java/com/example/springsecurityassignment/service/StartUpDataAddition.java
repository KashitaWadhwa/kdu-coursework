package com.example.springsecurityassignment.service;

import com.example.springsecurityassignment.dto.UserDto;
import com.example.springsecurityassignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.addUser(new UserDto("Kashita", passwordEncoder.encode("Kashita"), "kashita@kickdrumtech.com", "ROLE_ADMIN"));
        userRepository.addUser(new UserDto("Manya", passwordEncoder.encode("Manya"), "manya@kickdrumtech.com", "ROLE_USER"));
    }
}
