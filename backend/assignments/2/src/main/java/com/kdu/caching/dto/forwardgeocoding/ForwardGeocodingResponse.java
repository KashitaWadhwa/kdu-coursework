package com.kdu.caching.dto.forwardgeocoding;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class for forward geocoding response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForwardGeocodingResponse {

    Double latitude;
    Double longitude;
    @Setter
    String responseMessage;

    @Override
    public String toString() {
        return "GeoCodingResponseDTO{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
