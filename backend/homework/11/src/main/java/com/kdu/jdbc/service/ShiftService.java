package com.kdu.jdbc.service;

import com.kdu.jdbc.dao.ShiftDAO;
import com.kdu.jdbc.entity.ShiftEntity;
import com.kdu.jdbc.exception.DataNotFoundException;
import com.kdu.jdbc.exception.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShiftService {

    private final ShiftDAO shiftDAO;


    @Autowired
    public ShiftService(ShiftDAO shiftDAO) {
        this.shiftDAO = shiftDAO;
    }

    public void addShift(ShiftEntity shift) {
        try {
            shiftDAO.addShift(shift);
        } catch (Exception e) {
            throw new OperationException("Unable to add Shifts");
        }
    }

    public List<ShiftEntity> getAllShifts(UUID tenantId) {
        List<ShiftEntity> shiftList;
        try {
            shiftList = shiftDAO.getAllShifts(tenantId);
        } catch (Exception e) {
            throw new DataNotFoundException("No tenantID exists");
        }
        return shiftList;
    }
}