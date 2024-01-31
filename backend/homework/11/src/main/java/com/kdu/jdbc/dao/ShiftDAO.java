package com.kdu.jdbc.dao;

import com.kdu.jdbc.entity.ShiftEntity;
import com.kdu.jdbc.mapper.ShiftRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ShiftDAO {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public void addShift(ShiftEntity shift) {
        String sql = "INSERT INTO shifts (id, shift_type_id, name, date_start, date_end, time_start, time_end, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, UUID.randomUUID(), shift.getShiftTypeId(), shift.getName(), shift.getDateStart(), shift.getDateEnd(), shift.getTimeStart(), shift.getTimeEnd(), shift.getCreatedAt(), shift.getUpdatedAt(), shift.getTimezone(), shift.getTenantID());
    }

    public List<ShiftEntity> getAllShifts(UUID tenantId) {
        String sql = "SELECT * FROM shifts WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new ShiftRowMapper(), tenantId);
    }
}

