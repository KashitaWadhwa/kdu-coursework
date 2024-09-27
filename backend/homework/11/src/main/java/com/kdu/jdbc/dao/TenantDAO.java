package com.kdu.jdbc.dao;

import com.kdu.jdbc.entity.TenantEntity;
import com.kdu.jdbc.mapper.TenantRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TenantDAO {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public TenantDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<TenantEntity> getAllTenants() {
        String sql = "SELECT * FROM tenants";
        return jdbcTemplate.query(sql, new TenantRowMapper());
    }

}
