package com.kdu.jdbc.service;

import com.kdu.jdbc.dao.ShiftUserDAO;
import com.kdu.jdbc.entity.ShiftUsers;
import com.kdu.jdbc.exception.DataNotFoundException;
import com.kdu.jdbc.exception.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShiftUserService {

    private final ShiftUserDAO shiftUserDAO;

    @Autowired
    public ShiftUserService(ShiftUserDAO shiftUserDAO){
        this.shiftUserDAO=shiftUserDAO;
    }
    public void addShiftUser(ShiftUsers shiftUser) {
        try {
            shiftUserDAO.addShiftUser(shiftUser);
        } catch (Exception e) {
            throw new OperationException("Unable to add shift-user.");
        }
    }

    public List<ShiftUsers> getAllShiftUsers(UUID tenantId) {
        List<ShiftUsers> shiftUserList;
        try {
            shiftUserList = shiftUserDAO.getAllShiftUsers(tenantId);
        } catch (Exception e) {
            throw new DataNotFoundException("Cannot find shift-users for tenantId. Please check again.");
        }
        return shiftUserList;
    }
}
