package com.kdu.myapplication.service;

import com.kdu.myapplication.dao.AddressRepository;
import com.kdu.myapplication.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveaddress(Address address ){
        addressRepository.save(address);
    }

}
