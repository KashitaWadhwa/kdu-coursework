package com.kdu.myapplication.mapper;


import com.kdu.myapplication.dto.AddressDTO;
import com.kdu.myapplication.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address mapAddressDTO(AddressDTO addressDTO){
        Address address=new Address();
        address.setNickName(addressDTO.getNickName());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getStreet());
        address.setState(addressDTO.getState());
        address.setPostalCode(addressDTO.getPostalCode());
        return address;
    }
}