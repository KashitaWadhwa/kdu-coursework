package com.kdu.jdbc.mapper;

import com.kdu.jdbc.entity.ShiftEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ShiftRowMapper implements RowMapper<ShiftEntity> {
    @Override
    public ShiftEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShiftEntity shift = new ShiftEntity();
        shift.setId(rs.getObject("id", UUID.class));
        shift.setShiftTypeId(rs.getObject("shift_type_id", UUID.class));
        shift.setName(rs.getString("name"));
        shift.setDateStart(rs.getDate("date_start"));
        shift.setDateEnd(rs.getDate("date_end"));
        shift.setTimeStart(rs.getTime("time_start"));
        shift.setTimeEnd(rs.getTime("time_end"));
        shift.setCreatedAt(rs.getTimestamp("created_at"));
        shift.setUpdatedAt(rs.getTimestamp("updated_at"));
        shift.setTimezone(rs.getString("time_zone"));
        shift.setTenantID(rs.getObject("tenant_id", UUID.class));
        return shift;
    }
}