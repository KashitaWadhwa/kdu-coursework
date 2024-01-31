package com.kdu.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {
    private UUID id;
    private String username;
    private int loggedin;
    private String timezone;
    private UUID tenantId;
}
