package com.kdu.jdbc.controller;

import com.kdu.jdbc.dto.DTO;
import com.kdu.jdbc.entity.TenantEntity;
import com.kdu.jdbc.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenant")
public class TenantController {
    private final TenantService tenantService;

     @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping()
    public ResponseEntity<List<TenantEntity>> getAllTenants() {
        return ResponseEntity.ok(tenantService.getAllTenants());
    }

    @PostMapping()
    public ResponseEntity<String> addAllTenantEntities(@RequestBody DTO dto) {
        tenantService.addAllTenantEntities(dto);
        return new ResponseEntity<>("All details added successfully", HttpStatus.OK);
    }
}
