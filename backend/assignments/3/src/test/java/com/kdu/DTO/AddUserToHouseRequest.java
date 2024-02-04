package com.kdu.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddUserToHouseRequest {
    private String username;
}
