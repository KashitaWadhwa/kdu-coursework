package com.kdu.services;

import com.kdu.exceptions.custom.CustomException;
import com.kdu.model.dto.response.RoomResponseDTO;
import com.kdu.model.entity.House;
import com.kdu.model.entity.Room;
import com.kdu.mapper.AddRoomMapper;
import com.kdu.dao.HouseRegisterRepository;
import com.kdu.dao.AddRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddRoomService {
    private final AddRoomRepository addRoomRepository;
    private final HouseRegisterRepository houseRegisterRepository;
    private final AddRoomMapper addRoomMapper;

    @Autowired
    public AddRoomService(AddRoomRepository addRoomRepository,
                          HouseRegisterRepository houseRegisterRepository,
                          AddRoomMapper addRoomMapper) {
        this.addRoomRepository = addRoomRepository;
        this.houseRegisterRepository = houseRegisterRepository;
        this.addRoomMapper = addRoomMapper;
    }

    @Transactional
    public RoomResponseDTO addRoom(Long id, String roomName){

        Optional<House> optionalHouse = houseRegisterRepository.findById(id);
        if(optionalHouse.isPresent()){
            House house = optionalHouse.get();
            Room room = addRoomMapper.roomMapping(roomName,house);
            addRoomRepository.save(room);
            return new RoomResponseDTO("Room added successfully!",room, HttpStatus.OK);
        }
        else {
            throw new CustomException("House with given id not found!");
        }
    }
}
