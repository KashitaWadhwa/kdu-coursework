package com.kdu.controller;

import com.kdu.model.dto.request.AddDeviceRequestDTO;
import com.kdu.model.dto.request.DeviceRegisterRequestDTO;
import com.kdu.model.dto.response.FormatResponseDTO;
import com.kdu.services.DeviceRegisterService;
import com.kdu.model.utility.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeviceRegisterController {

    private final DeviceRegisterService deviceRegisterService;

    @Autowired
    public DeviceRegisterController(DeviceRegisterService deviceRegisterService) {
        this.deviceRegisterService = deviceRegisterService;
    }

    @PostMapping("/api/v1/device/register")
    public ResponseEntity<FormatResponseDTO> saveDevice(@RequestBody DeviceRegisterRequestDTO deviceRegisterRequestDTO){
        FormatResponseDTO formatResponseDTO = deviceRegisterService.saveDevice(deviceRegisterRequestDTO);
        return new ResponseEntity<>(formatResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/api/v1/device/add")
    public ResponseEntity<FormatResponseDTO> addDevice(@RequestBody AddDeviceRequestDTO addDeviceRequestDTO){
        if(!Convert.isParsable(addDeviceRequestDTO.getHouseId()) || !Convert.isParsable(addDeviceRequestDTO.getRoomId()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        FormatResponseDTO formatResponseDTO = deviceRegisterService.addDevice(addDeviceRequestDTO);
        return new ResponseEntity<>(formatResponseDTO,HttpStatus.OK);
    }
}
