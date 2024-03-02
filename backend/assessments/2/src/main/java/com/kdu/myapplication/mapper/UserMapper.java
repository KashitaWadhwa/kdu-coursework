package com.kdu.myapplication.mapper;

import com.kdu.myapplication.dto.AddressDTO;
import com.kdu.myapplication.dto.UserDTO;
import com.kdu.myapplication.entity.Address;
import com.kdu.myapplication.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public User mapUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        List<AddressDTO> addressDTOs = userDTO.getNickName();

        if (addressDTOs != null) {
            List<Address> addresses = addressDTOs.stream()
                    .map(addressDTO -> {
                        Address address = new Address();
                        address.setNickName(addressDTO.getNickName());
                        return address;
                    })
                    .toList();

            user.setNickName(addresses);
        }

        return user;

    }

}