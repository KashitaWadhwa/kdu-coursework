package com.kdu.caching.controller;

import com.kdu.caching.dto.forwardgeocoding.ForwardGeocodingRequest;
import com.kdu.caching.exceptions.ReverseGeocodingFailureException;
import com.kdu.caching.model.GeocodingData;
import com.kdu.caching.model.ReverseGeocodingData;
import com.kdu.caching.service.GeocodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeocodingController {

    private final GeocodingService geocodingService;

    @Autowired
    public GeocodingController(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    @GetMapping("/geocoding")
    public ResponseEntity<Object> forwardGeocoding(@RequestParam String address) {
            GeocodingData response = geocodingService.forwardGeocoding(address);
            return ResponseEntity.ok(response);

    }


    @GetMapping("/reverse-geocoding")
    public ResponseEntity<Object> reverseGeocoding(@RequestParam String latitude, @RequestParam String longitude) {
        try {
            double lat = Double.parseDouble(latitude);
            double lon = Double.parseDouble(longitude);
            ReverseGeocodingData response = geocodingService.reverseGeocoding(lat, lon);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new ReverseGeocodingFailureException("Reverse Geocoding");
        }
    }

//    @PostMapping("/clearCache")
//    public ResponseEntity<String> clearCache() {
//        geocodingService.clearCache();
//        return ResponseEntity.ok("Geocoding cache cleared.");
//    }
}
