package com.kdu.mapper;

import com.kdu.model.dto.request.DeviceRegisterRequestDTO;
import com.kdu.model.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceRegisterMapper {

    public Device deviceMapping(DeviceRegisterRequestDTO deviceRegisterRequestDTO){
        Device device = new Device();
        device.setDeviceUsername(deviceRegisterRequestDTO.getDeviceUsername());
        device.setDevicePassword(deviceRegisterRequestDTO.getDevicePassword());
        device.setKickstonId(deviceRegisterRequestDTO.getKickstonId());
        return device;
    }
}
