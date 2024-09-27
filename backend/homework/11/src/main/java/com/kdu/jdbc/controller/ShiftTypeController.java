package com.kdu.jdbc.controller;

import com.kdu.jdbc.dto.TenantDTO;
import com.kdu.jdbc.entity.ShiftTypeEntity;
import com.kdu.jdbc.service.ShiftTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifttype")
public class ShiftTypeController {
    private final ShiftTypeService shiftTypeService;
    @Autowired
    public ShiftTypeController(ShiftTypeService shiftTypeService) {
        this.shiftTypeService = shiftTypeService;
    }

    @PostMapping()
    public ResponseEntity<String> addShift(@RequestBody ShiftTypeEntity shiftType) {
        shiftTypeService.addShiftType(shiftType);
        return ResponseEntity.ok("Shift-type added successfully");
    }


    @GetMapping()
    public ResponseEntity<List<ShiftTypeEntity>> getAllShifts(@RequestBody TenantDTO tenantDTO) {
        List<ShiftTypeEntity> shiftTypes = shiftTypeService.getAllShiftTypes(tenantDTO.getId());
        return ResponseEntity.ok(shiftTypes);
    }
}
