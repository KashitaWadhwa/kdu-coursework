package com.kdu.caching.dto.reversegeocoding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class for reverse geocoding response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReverseGeocodingResponse {
//
//    @ApiModelProperty(value = "Address information")
//    private String address;

    String address;
    @Setter
    String responseMessage;

    @Override
    public String toString() {
        return "RevGeoCodingResponseDTO{" +
                "address='" + address + '\'' +
                '}';
    }
}
