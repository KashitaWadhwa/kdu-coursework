package com.kdu.jdbc.dao;

import com.kdu.jdbc.entity.ShiftTypeEntity;
import com.kdu.jdbc.mapper.ShiftTypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ShiftTypeDAO {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftTypeDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public void addShiftType(ShiftTypeEntity shiftType) {
        String sql = "INSERT INTO shift_types (id, uq_name, description, active, created_at,  updated_at,  time_zone, tenant_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, )";
        jdbcTemplate.update(sql, UUID.randomUUID(), shiftType.getUqName(), shiftType.getDescription(), shiftType.isActive(), shiftType.getCreatedAt(),  shiftType.getUpdatedAt(), shiftType.getTimezone(), shiftType.getTenantId());
    }

    public List<ShiftTypeEntity> getAllShiftTypes(UUID tenantId) {
        String sql = "SELECT * FROM shift_types WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new ShiftTypeRowMapper(),tenantId);
    }

}
