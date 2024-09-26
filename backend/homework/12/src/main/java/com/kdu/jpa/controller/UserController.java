package com.kdu.jpa.controller;

import com.kdu.jpa.dto.UsersDTO;
import com.kdu.jpa.entity.User;
import com.kdu.jpa.mapper.UserMapper;
import com.kdu.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    UserService userService;

    UserMapper userMapper;
    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody UsersDTO usersDTO){
        User user=userMapper.mapUserDTO(usersDTO);
        userService.saveUser(user);
        return new ResponseEntity<>("User Saved!", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<User>> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "50") int pageSize) {
        Page<User> usersPage = userService.findAllUsersPaginated(pageNumber, pageSize);
        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }

}
