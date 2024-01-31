package com.kdu.jdbc.dao;

import com.kdu.jdbc.entity.ShiftUsers;
import com.kdu.jdbc.mapper.ShiftUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ShiftUserDAO {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftUserDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void addShiftUser(ShiftUsers shiftUser) {
        String sql = "INSERT INTO shift_user (id, shift_id, user_id, tenant_id) VALUES (?, ?,  ?, ?)";
        jdbcTemplate.update(sql, UUID.randomUUID(), shiftUser.getShiftId(), shiftUser.getUserId(), shiftUser.getTenantId());
    }

    public List<ShiftUsers> getAllShiftUsers(UUID tenantId) {
        String sql = "SELECT * FROM shift_user WHERE tenant_id = ?";
        return jdbcTemplate.query(sql, new ShiftUserRowMapper(),tenantId);
    }
}
