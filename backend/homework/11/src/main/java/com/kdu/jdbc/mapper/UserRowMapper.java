package com.kdu.jdbc.mapper;

import com.kdu.jdbc.entity.UsersEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<UsersEntity> {
    @Override
    public UsersEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UsersEntity user = new UsersEntity();
        user.setId(rs.getObject("id", UUID.class));
        user.setUsername(rs.getString("username"));
        user.setLoggedin(rs.getShort("loggedin"));
        user.setTimezone(rs.getString("time_zone"));
        user.setTenantId(rs.getObject("tenant_id", UUID.class));
        return user;
    }
}