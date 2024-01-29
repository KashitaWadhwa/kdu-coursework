package com.kdu.caching.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Model class representing geocoding information.
 */
@Data
@AllArgsConstructor
public class GeocodingData {

    private String address;
    private double latitude;
    private double longitude;
}
