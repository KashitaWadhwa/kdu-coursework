package com.kdu.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceRequestDTO {
    private String houseId;
    private String roomId;
    private String kickstonId;
}
