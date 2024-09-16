package com.kdu.controller;

import com.kdu.services.AddRoomService;
import com.kdu.model.dto.request.RoomNameRequestDTO;
import com.kdu.model.dto.response.RoomResponseDTO;
import com.kdu.model.utility.Convert;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddRoomController {
    private final AddRoomService addRoomService;

    @Autowired
    public AddRoomController(AddRoomService addRoomService) {
        this.addRoomService = addRoomService;
    }
    @PostMapping("/api/v1/room")
    public ResponseEntity<RoomResponseDTO> addRoom(@RequestParam String houseId, @RequestBody RoomNameRequestDTO roomNameRequestDTO, HttpServletRequest request){
        if(!Convert.isParsable(houseId))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        RoomResponseDTO roomResponseDTO = addRoomService.addRoom(Long.parseLong(houseId), roomNameRequestDTO.getRoomName());
        return new ResponseEntity<>(roomResponseDTO, HttpStatus.OK);
    }
}
