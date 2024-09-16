package com.kdu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdu.model.UserNameRequestDTO;
import com.kdu.model.dto.request.HouseRegisterRequestDTO;
import com.kdu.model.dto.response.FormatResponseDTO;
import com.kdu.model.dto.response.GetHouseResponseDTO;
import com.kdu.model.dto.response.HouseResponseDTO;
import com.kdu.model.dto.response.RoomsDevicesDTO;
import com.kdu.model.utility.Convert;
import com.kdu.services.HouseRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HouseRegisterController {
    private final HouseRegisterService houseRegisterService;

    @Autowired
    public HouseRegisterController(HouseRegisterService houseRegisterService) {
        this.houseRegisterService = houseRegisterService;
    }
    @PostMapping("/api/v1/house")
    public ResponseEntity<HouseResponseDTO> addHouse(@RequestBody HouseRegisterRequestDTO houseRegisterRequestDTO, HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(7);
        HouseResponseDTO houseResponseDTO = houseRegisterService.addHouse(houseRegisterRequestDTO,token);
        return new ResponseEntity<>(houseResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/api/v1/house/{houseId}/add-user")
    public ResponseEntity<FormatResponseDTO> addUser(@PathVariable String houseId, @RequestBody UserNameRequestDTO userNameRequestDTO, HttpServletRequest request){
        String token = request.getHeader("Authorization").substring(7);
        FormatResponseDTO userHouseDTO = houseRegisterService.addUser(Long.parseLong(houseId),userNameRequestDTO.getUsername(),token);
        return new ResponseEntity<>(userHouseDTO,HttpStatus.OK);
    }

    @GetMapping("/api/v1/house")
    public ResponseEntity<GetHouseResponseDTO> getHouses() throws JsonProcessingException {
         GetHouseResponseDTO house = houseRegisterService.getAll();
        return new ResponseEntity<>(house,HttpStatus.OK);
    }

    @PutMapping("/api/v1/house")
    public ResponseEntity<FormatResponseDTO> updateAddress(@RequestParam String houseId, @RequestBody String newAddress) {
        if(!Convert.isParsable(houseId))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        FormatResponseDTO userHouseDTO = houseRegisterService.updateAddress(Long.parseLong(houseId),newAddress);
        return new ResponseEntity<>(userHouseDTO,HttpStatus.OK);
    }

    @GetMapping("/api/v1/house/{houseId}")
    public ResponseEntity<RoomsDevicesDTO> getRoomsDevices(@PathVariable String houseId) throws JsonProcessingException {
        RoomsDevicesDTO roomsDevicesDTO = houseRegisterService.getRoomsDevices(Long.parseLong(houseId));
        return new ResponseEntity<>(roomsDevicesDTO,HttpStatus.OK);
    }
}
