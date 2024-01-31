package com.kdu.jdbc.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class ShiftDTO {
    @JsonDeserialize
    private UUID shiftTypeId;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private Time timeStart;
    private Time timeEnd;
    private String timeZone;
    @JsonDeserialize
    private UUID tenantId;



}