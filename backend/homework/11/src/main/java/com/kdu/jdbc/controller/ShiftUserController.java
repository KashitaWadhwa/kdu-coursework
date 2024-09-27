package com.kdu.jdbc.controller;

import com.kdu.jdbc.dto.TenantDTO;
import com.kdu.jdbc.entity.ShiftUsers;
import com.kdu.jdbc.service.ShiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shiftuser")
public class ShiftUserController {
    private final ShiftUserService shiftUserService;

    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService) {
        this.shiftUserService = shiftUserService;
    }

    @PostMapping()
    public ResponseEntity<String> addShift(@RequestBody ShiftUsers shiftUser) {
        shiftUserService.addShiftUser(shiftUser);
        return ResponseEntity.ok("Shift-user added successfully");
    }

    @GetMapping()
    public ResponseEntity<List<ShiftUsers>> getAllShiftUsers(@RequestBody TenantDTO tenantDTO) {
        List<ShiftUsers> shiftUsers = shiftUserService.getAllShiftUsers(tenantDTO.getId());
        return ResponseEntity.ok(shiftUsers);
    }
}
