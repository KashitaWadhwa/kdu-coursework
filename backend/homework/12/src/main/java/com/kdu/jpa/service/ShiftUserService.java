package com.kdu.jpa.service;

import com.kdu.jpa.dao.ShiftUserRepository;
import com.kdu.jpa.entity.ShiftUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShiftUserService {



    private final ShiftUserRepository shiftUserRepository;

    @Autowired
    public ShiftUserService(ShiftUserRepository shiftUserRepository) {
        this.shiftUserRepository = shiftUserRepository;
    }

    public void saveshiftUser(ShiftUser shiftUser) {
        shiftUserRepository.save(shiftUser);
    }

    public void deleteShiftUser(UUID shiftUserId){
        shiftUserRepository.deleteById(shiftUserId);
    }
}