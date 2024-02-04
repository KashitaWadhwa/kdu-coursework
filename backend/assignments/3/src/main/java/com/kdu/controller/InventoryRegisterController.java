package com.kdu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdu.model.dto.request.InventoryRegisterRequestDTO;
import com.kdu.model.dto.response.FormatResponseDTO;
import com.kdu.model.dto.response.InventoryResponseDTO;
import com.kdu.services.InventoryRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryRegisterController {

    private final InventoryRegisterService inventoryRegisterService;

    @Autowired
    public InventoryRegisterController(InventoryRegisterService inventoryRegisterService) {
        this.inventoryRegisterService = inventoryRegisterService;
    }

    @PostMapping("/api/v1/inventory")
    public ResponseEntity<FormatResponseDTO> addItem(@RequestBody InventoryRegisterRequestDTO inventoryRegisterRequestDTO){
        FormatResponseDTO formatResponseDTO = inventoryRegisterService.addItem(inventoryRegisterRequestDTO);
        return new ResponseEntity<>(formatResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/api/v1/inventory")
    public ResponseEntity<InventoryResponseDTO> getItem() throws JsonProcessingException {
        InventoryResponseDTO inventoryResponseDTO = inventoryRegisterService.getItems();
        return new ResponseEntity<>(inventoryResponseDTO, HttpStatus.OK);
    }
}
