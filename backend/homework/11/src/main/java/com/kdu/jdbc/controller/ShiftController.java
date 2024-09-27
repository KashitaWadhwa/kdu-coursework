package com.kdu.jdbc.controller;

import com.kdu.jdbc.dto.TenantDTO;
import com.kdu.jdbc.entity.ShiftEntity;
import com.kdu.jdbc.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shift")
public class ShiftController {

    private final ShiftService shiftService;
    @Autowired
    public ShiftController(ShiftService shiftService){
        this.shiftService=shiftService;
    }

    @PostMapping()
    public ResponseEntity<String> addShift(@RequestBody ShiftEntity shift) {
        shiftService.addShift(shift);
        return ResponseEntity.ok("Shift has been added ");
    }


    @GetMapping()
    public ResponseEntity<List<ShiftEntity>> getAllShifts(@RequestBody TenantDTO tenantDTO) {
        List<ShiftEntity> shifts = shiftService.getAllShifts(tenantDTO.getId());
        return ResponseEntity.ok(shifts);
    }

}
