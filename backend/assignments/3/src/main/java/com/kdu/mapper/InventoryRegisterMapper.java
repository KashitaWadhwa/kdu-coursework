package com.kdu.mapper;

import com.kdu.model.dto.request.InventoryRegisterRequestDTO;
import com.kdu.model.entity.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryRegisterMapper {

    public Inventory inventoryMapping(InventoryRegisterRequestDTO inventoryRegisterRequestDTO){
        Inventory inventory = new Inventory();
        inventory.setKickstonId(inventoryRegisterRequestDTO.getKickstonId());
        inventory.setDeviceUsername(inventoryRegisterRequestDTO.getDeviceUsername());
        inventory.setDevicePassword(inventoryRegisterRequestDTO.getDevicePassword());
        inventory.setManufactureDateTime(inventoryRegisterRequestDTO.getManufactureDateTime());
        inventory.setManufactureFactoryPlace(inventoryRegisterRequestDTO.getManufactureFactoryPlace());

        return inventory;
    }
}
