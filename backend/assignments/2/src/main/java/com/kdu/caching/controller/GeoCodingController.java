package com.kdu.caching.controller;

import com.kdu.caching.dto.GeoCodingResponseDto;
import com.kdu.caching.exception.custom.ReverseGeocodingFailureException;
import com.kdu.caching.exception.custom.InvalidGeocodingInputException;
import com.kdu.caching.service.GeoCodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * GeoCodingController class is a controller class for GeoCodingService class.
 * This class is responsible for handling geocoding HTTP requests.
 */
@RestController
public class GeoCodingController {
    private final GeoCodingService geoCodingService;

    /**
     * Constructor injection.
     *
     * @param geoCodingService GeoCodingService class instance
     */
    @Autowired
    public GeoCodingController(GeoCodingService geoCodingService) {
        this.geoCodingService = geoCodingService;
    }

    /**
     * Handles the geocoding request and returns a response entity.
     *
     * @param address address to be searched
     * @return ResponseEntity<GeoCodingDto> response entity with GeoCodingDto object containing latitude and longitude
     * @throws InvalidGeocodingInputException if no data is found for the address
     */
    @GetMapping("/geocoding")
    public ResponseEntity<GeoCodingResponseDto> getGeoCoding(@RequestParam(required = true) String address) throws InvalidGeocodingInputException {
        return new ResponseEntity<>(geoCodingService.getGeoCoding(address), HttpStatus.OK);
    }

    /**
     * Handles the reverse geocoding request and returns the address.
     *
     * @param latitude  latitude of the location
     * @param longitude longitude of the location
     * @return String address obtained from reverse geocoding
     * @throws ReverseGeocodingFailureException if reverse geocoding fails
     */
    @GetMapping("/reverse-geocoding")
    public String getReverseGeoCoding(@RequestParam(required = true) String latitude, @RequestParam(required = true) String longitude) throws ReverseGeocodingFailureException {
        return geoCodingService.getReverseGeoCoding(latitude, longitude).getAddress();
    }
}
