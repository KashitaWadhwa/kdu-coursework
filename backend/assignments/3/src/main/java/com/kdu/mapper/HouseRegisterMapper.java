package com.kdu.mapper;

import com.kdu.model.dto.request.HouseRegisterRequestDTO;
import com.kdu.model.entity.House;
import com.kdu.model.entity.UserRegister;
import org.springframework.stereotype.Component;

@Component
public class HouseRegisterMapper {

    public House houseMapping(HouseRegisterRequestDTO houseRegisterRequestDTO, UserRegister userRegister){
        House house = new House();
        house.setHouseName(houseRegisterRequestDTO.getHouseName());
        house.setAddress(houseRegisterRequestDTO.getAddress());
        house.getUsersList().add(userRegister);
        return house;
    }
}
