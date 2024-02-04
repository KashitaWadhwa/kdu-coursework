package com.kdu.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseRegisterRequestDTO {
    private String address;

    @JsonProperty("house_name")
    private String houseName;
}
