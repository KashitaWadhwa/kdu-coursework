package com.kdu.myapplication.controller;

import com.kdu.myapplication.dto.UserDTO;
import com.kdu.myapplication.entity.User;
import com.kdu.myapplication.mapper.UserMapper;
import com.kdu.myapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UsersController {


    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
        log.error("Adding a new user to memory");
        User user = userMapper.mapUserDTO(userDTO);
        userService.saveUser(user);
        return ResponseEntity.ok("User Added successfully!");
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
}
