package com.kdu.caching.dto.reversegeocoding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for reverse geocoding request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReverseGeocodingRequest {

    private Double latitude;

    private Double longitude;
}
