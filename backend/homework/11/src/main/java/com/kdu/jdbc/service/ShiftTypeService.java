package com.kdu.jdbc.service;

import com.kdu.jdbc.dao.ShiftTypeDAO;
import com.kdu.jdbc.entity.ShiftTypeEntity;
import com.kdu.jdbc.exception.DataNotFoundException;
import com.kdu.jdbc.exception.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShiftTypeService {

    private final ShiftTypeDAO shiftTypeDAO;


    @Autowired
    public ShiftTypeService(ShiftTypeDAO shiftTypeDAO) {
        this.shiftTypeDAO = shiftTypeDAO;
    }
    public void addShiftType(ShiftTypeEntity shiftType) {
        try {
            shiftTypeDAO.addShiftType(shiftType);
        } catch (Exception e) {
            throw new OperationException("Unable to add shift-type");
        }
    }
    public List<ShiftTypeEntity> getAllShiftTypes(UUID tenantId) {
        List<ShiftTypeEntity> shiftTypeList;
        try {
            shiftTypeList = shiftTypeDAO.getAllShiftTypes(tenantId);
        } catch (Exception e) {
            throw new DataNotFoundException("No shift-types for tenantId exists for id ");
        }
        return shiftTypeList;
    }
}
