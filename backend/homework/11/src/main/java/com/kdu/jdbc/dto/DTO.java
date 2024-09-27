package com.kdu.jdbc.dto;


import com.kdu.jdbc.entity.ShiftEntity;
import com.kdu.jdbc.entity.ShiftTypeEntity;
import com.kdu.jdbc.entity.ShiftUsers;
import com.kdu.jdbc.entity.UsersEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DTO {

    private UsersEntity user;
    private ShiftEntity shift;
    private ShiftTypeEntity shiftType;
    private ShiftUsers shiftUser;

}