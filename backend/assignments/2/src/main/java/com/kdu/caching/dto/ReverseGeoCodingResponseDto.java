package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ReverseGeoCodingDto class is used to store the address and region based on the latitude and longitude.
 * This class is used to return the response of the Reverse GeoCoding API.
 */
@Data
@AllArgsConstructor
public class ReverseGeoCodingResponseDto {
    private String address;
    private String region;
}
