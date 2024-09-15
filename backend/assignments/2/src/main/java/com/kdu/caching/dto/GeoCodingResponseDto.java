package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GeoCodingDto class is used to store the latitude, longitude and region of the address.
 * This class is used to return the response of the GeoCoding API.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoCodingResponseDto {
    private Double latitude;
    private Double longitude;
    private String region;
}
