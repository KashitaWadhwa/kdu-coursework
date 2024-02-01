package com.kdu.jpa.controller;

import com.kdu.jpa.dto.ShiftTypeDTO;
import com.kdu.jpa.entity.ShiftType;
import com.kdu.jpa.mapper.ShiftTypeMapper;
import com.kdu.jpa.service.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftTypeController {

    ShiftTypeService shiftTypeService;

   ShiftTypeMapper shiftTypeMapper;

    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService, ShiftTypeMapper shiftTypeMapper) {
        this.shiftTypeService = shiftTypeService;
        this.shiftTypeMapper = shiftTypeMapper;
    }

    @PostMapping("/shiftType")
    public ResponseEntity<String> saveShiftType(@RequestBody ShiftTypeDTO shiftTypeDTO){
        ShiftType shiftType = shiftTypeMapper.mapShiftTypeDTO(shiftTypeDTO);
        shiftTypeService.saveshiftType(shiftType);
        return new ResponseEntity<>("Shift Type Saved!", HttpStatus.CREATED);
    }
}
