package com.kdu.mapper;

import com.kdu.model.entity.House;
import com.kdu.model.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class AddRoomMapper {

    public Room roomMapping(String roomName, House house){
        Room room = new Room();
        room.setRoomName(roomName);
        room.setHouse(house);
        return room;
    }
}
