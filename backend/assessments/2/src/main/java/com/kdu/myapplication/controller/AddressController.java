package com.kdu.myapplication.controller;

import com.kdu.myapplication.dto.AddressDTO;
import com.kdu.myapplication.entity.Address;
import com.kdu.myapplication.mapper.AddressMapper;
import com.kdu.myapplication.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    AddressService addressService;

    AddressMapper addressMapper;
    @Autowired

    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @PostMapping("/address")
    public ResponseEntity<String> saveAddress(@RequestBody AddressDTO addressDTO){
        Address address=addressMapper.mapAddressDTO(addressDTO);
        addressService.saveaddress(address);
        return new ResponseEntity<>("Address successfully saved!!!", HttpStatus.CREATED);
    }
}
