package com.kdu.caching.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.kdu.caching.dto.GeoCodingResponseDto;
import com.kdu.caching.dto.ReverseGeoCodingResponseDto;
import com.kdu.caching.exception.custom.InvalidGeocodingInputException;
import com.kdu.caching.exception.custom.ReverseGeocodingFailureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Service class for geocoding.
 * This class is responsible for fetching the geocoding data from the external API and caching it.
 * The caching is done using Spring's InMemoryCache.
 */
@Service
public class GeoCodingService {

    @Value("${geocoding-url}")
    private String positionStackGeoCodingUrl;

    @Value("${reverse-geocoding-url}")
    private String positionStackReverseGeoCodingUrl;

    @Value("${api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Retrieves geocoding information for the given address.
     *
     * @param address the address to be geocoded
     * @return GeoCodingResponseDto containing latitude, longitude, and region information
     * @throws InvalidGeocodingInputException if no data is found or the data is invalid
     */
    @Cacheable(value = "geocoding", key = "#address", unless = "#result==null || #result.region==null || #result.region.equals('Goa')")
    public GeoCodingResponseDto getGeoCoding(String address) throws InvalidGeocodingInputException {
        String query = URLEncoder.encode(address, StandardCharsets.UTF_8);
        JsonNode responseFromPositionStack = restTemplate.getForObject(positionStackGeoCodingUrl + apiKey + "&query=" + query, JsonNode.class);

        if (Objects.isNull(responseFromPositionStack) || !responseFromPositionStack.has("data") || !responseFromPositionStack.get("data").isArray() || responseFromPositionStack.get("data").size() == 0) {
            throw new InvalidGeocodingInputException("No data found");
        }

        JsonNode info = responseFromPositionStack.get("data").get(0);

        if (Objects.isNull(info)) {
            throw new InvalidGeocodingInputException("No data found");
        }

        return new GeoCodingResponseDto(info.get("latitude").asDouble(), info.get("longitude").asDouble(), info.get("region").asText());
    }

    /**
     * Retrieves reverse geocoding information for the given coordinates.
     *
     * @param latitude  latitude of the location
     * @param longitude longitude of the location
     * @return ReverseGeoCodingResponseDto containing label and region information
     * @throws ReverseGeocodingFailureException if coordinates are invalid or no data is found
     */
    @Cacheable(value = "reverse-geocoding", key = "#latitude + ',' + #longitude")
    public ReverseGeoCodingResponseDto getReverseGeoCoding(String latitude, String longitude) throws ReverseGeocodingFailureException {
        if (latitude.isEmpty() || longitude.isEmpty()) {
            throw new ReverseGeocodingFailureException("Please enter the coordinates");
        }

        Double lat;
        Double lon;

        try {
            lat = Double.parseDouble(latitude);
            lon = Double.parseDouble(longitude);
        } catch (NumberFormatException e) {
            throw new ReverseGeocodingFailureException("Please enter the coordinates in valid range");
        }

        String query = lat + "," + lon;
        JsonNode responseFromPositionStack = restTemplate.getForObject(positionStackReverseGeoCodingUrl + apiKey + "&query=" + query, JsonNode.class);
        JsonNode info;

        try {
            if (responseFromPositionStack != null && responseFromPositionStack.has("data") && responseFromPositionStack.get("data").isArray() && responseFromPositionStack.get("data").size() > 0) {
                info = responseFromPositionStack.get("data").get(0);
            } else {
                throw new ReverseGeocodingFailureException("No data found for the coordinates");
            }
        } catch (NullPointerException e) {
            throw new ReverseGeocodingFailureException("Please enter the valid coordinates");
        }

        if (Objects.isNull(info)) {
            throw new ReverseGeocodingFailureException("Please enter valid coordinates");
        }

        return new ReverseGeoCodingResponseDto(info.get("label").asText(), info.get("region").asText());
    }
}
