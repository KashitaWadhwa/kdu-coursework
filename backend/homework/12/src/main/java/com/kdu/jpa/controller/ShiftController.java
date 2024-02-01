package com.kdu.jpa.controller;

import com.kdu.jpa.dto.ShiftDTO;
import com.kdu.jpa.entity.Shift;
import com.kdu.jpa.mapper.ShiftMapper;
import com.kdu.jpa.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ShiftController {

    ShiftService shiftservice;

    ShiftMapper shiftMapper;

    @Autowired
    public ShiftController(ShiftService shiftservice, ShiftMapper shiftMapper) {
        this.shiftservice = shiftservice;
        this.shiftMapper = shiftMapper;
    }

    @PostMapping("/shift")
    public ResponseEntity<String> saveShift(@RequestBody ShiftDTO shiftDTO){
        Shift shift=shiftMapper.mapShiftDTO(shiftDTO);
        shiftservice.saveShift(shift);
        return new ResponseEntity<>("Shift Saved!", HttpStatus.CREATED);
    }

    @GetMapping("/top3")
    public ResponseEntity<List<Shift>> findTop3ShiftsByDateRange(
            @RequestParam("startDate") Date startDate,
            @RequestParam("endDate") Date endDate) {
        List<Shift> top3Shifts = shiftservice.findTop3ShiftsByDateRange(startDate, endDate);
        return new ResponseEntity<>(top3Shifts, HttpStatus.OK);
    }

}
