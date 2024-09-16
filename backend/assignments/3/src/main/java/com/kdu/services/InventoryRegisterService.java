package com.kdu.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdu.mapper.InventoryRegisterMapper;
import com.kdu.model.dto.request.InventoryRegisterRequestDTO;
import com.kdu.model.dto.response.FormatResponseDTO;
import com.kdu.model.dto.response.InventoryResponseDTO;
import com.kdu.model.entity.Inventory;
import com.kdu.model.utility.JsonUtils;
import com.kdu.dao.InventoryRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryRegisterService {
    private final InventoryRegisterRepository inventoryRegisterRepository;
    private final InventoryRegisterMapper inventoryRegisterMapper;
    private final JsonUtils jsonUtil;

    @Autowired
    public InventoryRegisterService(InventoryRegisterRepository inventoryRegisterRepository,
                                    InventoryRegisterMapper inventoryRegisterMapper,
                                    JsonUtils jsonUtils) {
        this.inventoryRegisterRepository = inventoryRegisterRepository;
        this.inventoryRegisterMapper = inventoryRegisterMapper;
        this.jsonUtil = jsonUtils;
    }

    public FormatResponseDTO addItem(InventoryRegisterRequestDTO inventoryRegisterRequestDTO){
        Inventory inventory = inventoryRegisterMapper.inventoryMapping(inventoryRegisterRequestDTO);
        inventoryRegisterRepository.save(inventory);
        return new FormatResponseDTO("Device added successfully!","Kickston ID : ".concat(inventory.getKickstonId()), HttpStatus.OK);
    }

    public InventoryResponseDTO getItems() throws JsonProcessingException {
        List<Inventory> inventories = inventoryRegisterRepository.findAll();
        String inventoryJSON = jsonUtil.convertListToJSONString(inventories);
        return new InventoryResponseDTO(inventoryJSON,HttpStatus.OK);
    }
}
