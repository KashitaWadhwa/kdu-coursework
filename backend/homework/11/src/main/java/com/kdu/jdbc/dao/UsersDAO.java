package com.kdu.jdbc.dao;

import com.kdu.jdbc.entity.UsersEntity;
import com.kdu.jdbc.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public class UsersDAO {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public UsersDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void addUser(UsersEntity user) {
        String sql = "INSERT INTO users (id, username, loggedin, time_zone, tenant_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, UUID.randomUUID(), user.getUsername(), user.getLoggedin(), new Timestamp(System.currentTimeMillis()), user.getTimezone(), user.getTenantId());
    }

    public List<UsersEntity> getAllUsers(UUID tenantId) {
        String sql = "SELECT * FROM users WHERE tenant_id = ?";
        return jdbcTemplate.query(sql,new UserRowMapper(),tenantId);
    }

    public void updateUser(UUID userId, UsersEntity user) {
        String sql = "UPDATE users SET username = ?, tenant_id = ?, updated_by = ?, updated_at = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getTenantId(), new Timestamp(System.currentTimeMillis()), userId);
    }
}
