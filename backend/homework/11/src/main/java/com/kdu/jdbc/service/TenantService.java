package com.kdu.jdbc.service;

import com.kdu.jdbc.dao.*;
import com.kdu.jdbc.dto.DTO;
import com.kdu.jdbc.entity.TenantEntity;
import com.kdu.jdbc.exception.OperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    private final TenantDAO tenantDAO;


    private final UsersDAO usersDAO;
    private final ShiftUserDAO shiftUserDAO;
    private final ShiftTypeDAO shiftTypeDAO;
    private final ShiftDAO shiftDAO;

    @Autowired
    public TenantService(TenantDAO tenantDAO, UsersDAO usersDAO, ShiftUserDAO shiftUserDAO, ShiftTypeDAO shiftTypeDAO, ShiftDAO shiftDAO) {
        this.tenantDAO = tenantDAO;
        this.usersDAO = usersDAO;
        this.shiftUserDAO = shiftUserDAO;
        this.shiftTypeDAO = shiftTypeDAO;
        this.shiftDAO = shiftDAO;
    }

    public List<TenantEntity> getAllTenants() {
        return tenantDAO.getAllTenants();
    }

    public void addAllTenantEntities(DTO dto) {
        try {
            usersDAO.addUser(dto.getUser());
            shiftDAO.addShift(dto.getShift());
            shiftTypeDAO.addShiftType(dto.getShiftType());
            shiftUserDAO.addShiftUser(dto.getShiftUser());
        } catch (Exception e) {
            throw new OperationException("Unable to add details");
        }
    }


}
