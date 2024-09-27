package com.kdu.jdbc.mapper;

import com.kdu.jdbc.entity.ShiftTypeEntity;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ShiftTypeRowMapper implements RowMapper<ShiftTypeEntity> {
    @Override
    public ShiftTypeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShiftTypeEntity shiftType = new ShiftTypeEntity();
        shiftType.setId(rs.getObject("id", UUID.class));
        shiftType.setUqName(rs.getString("uq_name"));
        shiftType.setDescription(rs.getString("description"));
        shiftType.setActive(rs.getBoolean("active"));
        shiftType.setCreatedAt(rs.getTimestamp("created_at"));
        shiftType.setUpdatedAt(rs.getTimestamp("updated_at"));
        shiftType.setTimezone(rs.getString("time_zone"));
        shiftType.setTenantId(rs.getObject("tenant_id", UUID.class));
        return shiftType;
    }
}