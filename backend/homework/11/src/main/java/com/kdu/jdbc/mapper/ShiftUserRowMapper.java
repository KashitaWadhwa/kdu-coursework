package com.kdu.jdbc.mapper;

import com.kdu.jdbc.entity.ShiftUsers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ShiftUserRowMapper implements RowMapper<ShiftUsers> {
    @Override
    public ShiftUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShiftUsers shiftUser = new ShiftUsers();
        shiftUser.setId(rs.getObject("id", UUID.class));
        shiftUser.setShiftId(rs.getObject("shift_id", UUID.class));
        shiftUser.setUserId(rs.getObject("user_id", UUID.class));
        shiftUser.setTenantId(rs.getObject("tenant_id", UUID.class));
        return shiftUser;
    }
}