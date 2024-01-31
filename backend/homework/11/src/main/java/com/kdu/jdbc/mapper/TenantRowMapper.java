package com.kdu.jdbc.mapper;

import com.kdu.jdbc.entity.TenantEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TenantRowMapper implements RowMapper<TenantEntity> {
        @Override
        public TenantEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            TenantEntity tenant = new TenantEntity();
            tenant.setId(UUID.fromString(rs.getString("id")));
            tenant.setName(rs.getString("name"));
            tenant.setCreatedAt(rs.getTimestamp("created_at"));
            tenant.setCreatedBy(rs.getString("created_by"));
            tenant.setUpdatedAt(rs.getTimestamp("updated_at"));
            tenant.setUpdatedBy(rs.getString("updated_by"));
            return tenant;
        }
    }

