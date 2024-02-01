package com.kdu.jpa.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kdu.jpa.entity.Shift;
import com.kdu.jpa.entity.Tenant;
import com.kdu.jpa.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShiftUserDTO {

    @JsonDeserialize
    private Shift shiftId;
    @JsonDeserialize
    private User userId;
    @JsonDeserialize
    private Tenant tenantId;

}