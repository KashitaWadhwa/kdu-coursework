package com.kdu.jdbc.controller;

import com.kdu.jdbc.dto.TenantDTO;
import com.kdu.jdbc.entity.UsersEntity;
import com.kdu.jdbc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UsersService userService;

    @Autowired
    public UserController(UsersService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> addUser(@RequestBody UsersEntity user) {
        userService.addUser(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UsersEntity>> getAllUsers(@RequestBody TenantDTO tenantDTO) {
        List<UsersEntity> users = userService.getAllUsers(tenantDTO.getId());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable UUID userId, @RequestBody UsersEntity user) {
        userService.updateUser(userId, user);
        return ResponseEntity.ok("User updated successfully");
    }
}
