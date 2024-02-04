package com.kdu.model.dto.response;

import com.kdu.model.entity.Device;
import com.kdu.model.entity.House;
import com.kdu.model.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRoomsDevicesDTO {
    private House house;
    private List<Room> rooms;
    private List<Device> devices;
}
