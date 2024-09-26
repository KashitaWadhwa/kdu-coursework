package com.kdu.jpa.controller;

import com.kdu.jpa.dto.ShiftUserDTO;
import com.kdu.jpa.entity.ShiftUser;
import com.kdu.jpa.mapper.ShiftUserMapper;
import com.kdu.jpa.service.ShiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ShiftUserController {

    ShiftUserService shiftUserService;

    ShiftUserMapper shiftUserMapper;

    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService, ShiftUserMapper shiftUserMapper) {
        this.shiftUserService = shiftUserService;
        this.shiftUserMapper = shiftUserMapper;
    }

    @PostMapping("/shiftUser")
    public ResponseEntity<String> saveShiftUser(@RequestBody ShiftUserDTO shiftUserDTO){
        ShiftUser shiftUser = shiftUserMapper.mapShiftUserDTO(shiftUserDTO);
        shiftUserService.saveshiftUser(shiftUser);
        return new ResponseEntity<>("Shift User Saved!", HttpStatus.CREATED);
    }

    @DeleteMapping("/shiftUser/{shiftUserId}")
    public ResponseEntity<String> deleteShiftUser(@PathVariable UUID shiftUserId){
        shiftUserService.deleteShiftUser(shiftUserId);
        return new ResponseEntity<>("Shift User with Id:"+shiftUserId+"delelted successfully",HttpStatus.FOUND);
    }
}
