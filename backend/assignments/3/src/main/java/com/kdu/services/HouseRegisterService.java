package com.kdu.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kdu.exceptions.custom.CustomException;
import com.kdu.exceptions.custom.InvalidAuthException;
import com.kdu.model.dto.response.*;
import com.kdu.model.dto.request.HouseRegisterRequestDTO;
import com.kdu.model.entity.Device;
import com.kdu.model.entity.House;
import com.kdu.model.entity.Room;
import com.kdu.model.entity.UserRegister;
import com.kdu.mapper.HouseRegisterMapper;
import com.kdu.dao.HouseRegisterRepository;
import com.kdu.dao.UserRegisterRepository;
import com.kdu.model.utility.JsonUtils;
import com.kdu.model.utility.JwttokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseRegisterService {
    private final HouseRegisterRepository houseRegisterRepository;
    private final UserRegisterRepository userRegisterRepository;
    private final JwttokenUtils jwtUtil;
    private final HouseRegisterMapper houseRegisterMapper;
    private final JsonUtils jsonUtil;

    @Autowired
    public HouseRegisterService(HouseRegisterRepository houseRegisterRepository,
                                UserRegisterRepository userRegisterRepository,
                                JwttokenUtils jwtUtil,
                                HouseRegisterMapper houseRegisterMapper,
                                JsonUtils jsonUtils) {
        this.houseRegisterRepository = houseRegisterRepository;
        this.userRegisterRepository = userRegisterRepository;
        this.jwtUtil = jwtUtil;
        this.houseRegisterMapper = houseRegisterMapper;
        this.jsonUtil = jsonUtils;
    }

    public HouseResponseDTO addHouse(HouseRegisterRequestDTO houseRegisterRequestDTO, String token){
        String username = jwtUtil.decodeToken(token);
        Optional<UserRegister> optionalUser = userRegisterRepository.findByUsername(username);
        if(optionalUser.isEmpty())
            throw new InvalidAuthException("User not found");

        UserRegister user = optionalUser.get();
        user.setRole("ROLE_ADMIN");
        House house = houseRegisterMapper.houseMapping(houseRegisterRequestDTO,user);
        userRegisterRepository.save(user);
        houseRegisterRepository.save(house);
        return new HouseResponseDTO("House added successfully!",house, HttpStatus.OK);
    }

    public FormatResponseDTO addUser(Long id, String username, String token){
        String userAdmin = jwtUtil.decodeToken(token);
        Optional<UserRegister> optionalUser = userRegisterRepository.findByUsername(userAdmin);
        if(optionalUser.isEmpty())
            throw new InvalidAuthException("User Not found");

        UserRegister user = optionalUser.get();
        if(user.getRole().equals("ROLE_ADMIN")){
            Optional<House> optionalHouse = houseRegisterRepository.findById(id);
            if(optionalHouse.isPresent()){
                House house = optionalHouse.get();
                Optional<UserRegister> optionalUserModel = userRegisterRepository.findByUsername(username);
                if(optionalUserModel.isEmpty())
                    throw new InvalidAuthException("User Not found");


                house.getUsersList().add(optionalUserModel.get());
                return new FormatResponseDTO("User added successfully!","Username : ".concat(username),HttpStatus.OK);
            }
            else {
                throw new CustomException("House with given id not found");
            }
        }
        else{
            throw new InvalidAuthException("Given user is not admin!");
        }
    }

    public GetHouseResponseDTO getAll() throws JsonProcessingException {
        List<House> houseList = houseRegisterRepository.findAll();
        String houses = jsonUtil.convertListToJSONString(houseList);
        return new GetHouseResponseDTO("Fetched Successfully!",houses,HttpStatus.OK);
    }

    public FormatResponseDTO updateAddress(Long id, String newAddress){
        Optional<House> optHouse = houseRegisterRepository.findById(id);
        if(optHouse.isPresent()){
            House house = optHouse.get();
            house.setAddress(newAddress);
            houseRegisterRepository.save(house);
            return new FormatResponseDTO("House updated successfully!","New Address : ".concat(newAddress),HttpStatus.OK);
        }
        else{
            throw new CustomException("House with given id not found");
        }
    }

    public RoomsDevicesDTO getRoomsDevices(Long id) throws JsonProcessingException {
        Optional<House> optionalHouse = houseRegisterRepository.findById(id);
        if(optionalHouse.isPresent()){
            House house = optionalHouse.get();
            List<Room> rooms = house.getRooms();
            List<Device> devices = new ArrayList<>();
            for(Room room : rooms){
                List<Device> deviceList = room.getDeviceList();
                devices.addAll(deviceList);
            }
            ResponseRoomsDevicesDTO responseRoomsDevicesDTO = new ResponseRoomsDevicesDTO(house,rooms,devices);
            String roomsDevices = jsonUtil.convertObjToJSONString(responseRoomsDevicesDTO);
            return new RoomsDevicesDTO("Fetched successfully!",roomsDevices,HttpStatus.OK);
        }
        else{
            throw new CustomException("House with given id not found!");
        }

    }
}
