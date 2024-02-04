package com.kdu.mapper;

import com.kdu.model.dto.request.HouseRegisterRequestDTO;
import com.kdu.model.entity.House;
import com.kdu.model.entity.UserModel;
import org.springframework.stereotype.Component;

@Component
public class HouseRegisterMapper {

    public House houseMapping(HouseRegisterRequestDTO houseRegisterRequestDTO, UserModel userModel){
        House house = new House();
        house.setHouseName(houseRegisterRequestDTO.getHouseName());
        house.setAddress(houseRegisterRequestDTO.getAddress());
        house.getUsersList().add(userModel);
        return house;
    }
}
