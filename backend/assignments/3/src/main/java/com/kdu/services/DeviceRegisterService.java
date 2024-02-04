package com.kdu.services;

import com.kdu.exceptions.custom.CustomException;
import com.kdu.exceptions.custom.InvalidAuthException;
import com.kdu.model.dto.request.AddDeviceRequestDTO;
import com.kdu.model.dto.request.DeviceRegisterRequestDTO;
import com.kdu.model.dto.response.FormatResponseDTO;
import com.kdu.model.entity.Device;
import com.kdu.model.entity.House;
import com.kdu.model.entity.Inventory;
import com.kdu.model.entity.Room;
import com.kdu.mapper.DeviceRegisterMapper;
import com.kdu.dao.DeviceRegisterRepository;
import com.kdu.dao.HouseRegisterRepository;
import com.kdu.dao.InventoryRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DeviceRegisterService {
    private final DeviceRegisterRepository deviceRegisterRepository;
    private final InventoryRegisterRepository inventoryRegisterRepository;
    private final DeviceRegisterMapper deviceRegisterMapper;
    private final HouseRegisterRepository houseRegisterRepository;

    @Autowired
    public DeviceRegisterService(DeviceRegisterRepository deviceRegisterRepository,
                                 InventoryRegisterRepository inventoryRegisterRepository,
                                 DeviceRegisterMapper deviceRegisterMapper,
                                 HouseRegisterRepository houseRegisterRepository) {
        this.deviceRegisterRepository = deviceRegisterRepository;
        this.inventoryRegisterRepository = inventoryRegisterRepository;
        this.deviceRegisterMapper = deviceRegisterMapper;
        this.houseRegisterRepository = houseRegisterRepository;
    }

    public FormatResponseDTO saveDevice(DeviceRegisterRequestDTO deviceRegisterRequestDTO){
        Optional<Inventory> optionalInventory = inventoryRegisterRepository.findByKickstonId(deviceRegisterRequestDTO.getKickstonId());
        if(optionalInventory.isPresent() && optionalInventory.get().getDeviceUsername().equals(deviceRegisterRequestDTO.getDeviceUsername())){
            Inventory inventory = optionalInventory.get();
            if(deviceRegisterRequestDTO.getDevicePassword().equals(inventory.getDevicePassword())){
                Device device = deviceRegisterMapper.deviceMapping(deviceRegisterRequestDTO);
                deviceRegisterRepository.save(device);
                return new FormatResponseDTO("Device registered successfully!","Kickston id : ".concat(device.getKickstonId()), HttpStatus.OK);
            }
            else{
                throw new InvalidAuthException("Incorrect password!");
            }
        }
        else{
            throw new CustomException("Device not found in inventory!");
        }
    }

    public FormatResponseDTO addDevice(AddDeviceRequestDTO addDeviceRequestDTO){
        Optional<Device> optionalDevice = deviceRegisterRepository.findByKickstonId(addDeviceRequestDTO.getKickstonId());
        Optional<House> optionalHouse = houseRegisterRepository.findById(Long.parseLong(addDeviceRequestDTO.getHouseId()));

        if(optionalHouse.isPresent() && optionalDevice.isPresent()){
            House house = optionalHouse.get();
            Device device = optionalDevice.get();

            Long roomId = Long.parseLong(addDeviceRequestDTO.getRoomId());
            Optional<Room> optionalRoom = house.getRooms().stream()
                    .filter(room -> room.getId().equals(roomId))
                    .findFirst();

            if (optionalRoom.isPresent()) {
                Room room = optionalRoom.get();
                device.setRoom(room);
                deviceRegisterRepository.save(device);
                return new FormatResponseDTO("Device added successfully!", "Room: ".concat(addDeviceRequestDTO.getRoomId()), HttpStatus.OK);
            } else {
                throw new CustomException("Room with the given id not found!");
            }

        }
        else{
            if(optionalDevice.isEmpty() && optionalHouse.isEmpty())
                throw new CustomException("House and Device with given id not found!");
            else if (optionalHouse.isEmpty()) {
                throw new CustomException("House with given id not found!");
            }
            else{
                throw new CustomException("Device with given id not found!");
            }
        }

    }
}

