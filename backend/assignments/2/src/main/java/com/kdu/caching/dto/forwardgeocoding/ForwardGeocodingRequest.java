package com.kdu.caching.dto.forwardgeocoding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class for forward geocoding request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForwardGeocodingRequest {

    private String address;
}


