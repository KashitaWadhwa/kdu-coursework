package com.kdu.caching.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdu.caching.dto.forwardgeocoding.ForwardGeocodingRequest;
import com.kdu.caching.exceptions.GeocodingException;
import com.kdu.caching.model.GeocodingData;
import com.kdu.caching.model.ReverseGeocodingData;
import com.kdu.caching.utils.GeocodingUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {

    public GeocodingService() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(GeocodingService.class);

    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Value("${api-key}")
    private String apiKey;
    @Value("${geocoding-url}")
    private String geocodingUrl;
    @Value("${reverse-geocoding-url}")
    private String reverseGeocodingUrl;


    @Cacheable(value = GeocodingUtils.FORWARD_GEOCODING_NAME, key = GeocodingUtils.FORWARD_GEOCODING_KEY_PREFIX)
    public GeocodingData forwardGeocoding(String request) {
        try {
            // Build the URI using UriComponentsBuilder
            String apiUrl = geocodingUrl + apiKey + "&query=" + request;

            LOGGER.info("Constructed API URL: {}", apiUrl);

            JsonNode apiResponse = restTemplate.getForObject(apiUrl, JsonNode.class);
            LOGGER.info("API Response: {}", apiResponse);
            try {
                JsonNode data = apiResponse.get("data").get(0);
                return parseForwardApiResponse(data);
            } catch (Exception e) {
                LOGGER.error("Error parsing geocoding API response: {}", e.getMessage());
                throw new GeocodingException("Failed to parse geocoding API response.");
            }
        } catch (Exception e) {
            LOGGER.error("Error during geocoding for address '{}': {}", request, e.getMessage());
            throw new GeocodingException("Failed to retrieve geocoding information for address: " + request);
        }
    }

    @Cacheable(value = GeocodingUtils.REVERSE_GEOCODING_NAME, key = "#latitude + ',' + #longitude")
    public ReverseGeocodingData reverseGeocoding(double latitude, double longitude) {
        try {
            String apiUrl = reverseGeocodingUrl + apiKey + "&query=" + latitude + "," + longitude;
            JsonNode apiResponse = restTemplate.getForObject(apiUrl, JsonNode.class);
            try {
                JsonNode data = apiResponse.get("data").get(0);
                return parseReverseApiResponse(data);
            } catch (Exception e) {
                LOGGER.error("Error parsing geocoding API response: {}", e.getMessage());
                throw new GeocodingException("Failed to parse geocoding API response.");
            }
        } catch (Exception e) {
            LOGGER.error("Error during reverse geocoding for latitude '{}' and longitude '{}': {}", latitude, longitude, e.getMessage());
            throw new GeocodingException("Failed to retrieve reverse geocoding information for latitude and longitude.");
        }
    }

//    @CacheEvict(value = {GeocodingUtils.FORWARD_GEOCODING_NAME, GeocodingUtils.REVERSE_GEOCODING_NAME}, allEntries = true)
//    public void clearCache() {
//        LOGGER.info("Geocoding cache cleared.");
//        // Additional cache eviction logic can be added if needed
//    }

    private GeocodingData parseForwardApiResponse(JsonNode jsonNode) {
        try {
            String address = jsonNode.get("region").asText();
            double latitude = jsonNode.get("latitude").asDouble();
            double longitude = jsonNode.get("longitude").asDouble();

            return new GeocodingData(address, latitude, longitude);
        } catch (Exception e) {
            LOGGER.error("Error parsing geocoding API response: {}", e.getMessage());
            throw new GeocodingException("Failed to parse geocoding API response.");
        }
    }

    private ReverseGeocodingData parseReverseApiResponse(JsonNode jsonNode) {
        try {
            String address = jsonNode.get("label").asText();

            return new ReverseGeocodingData(address);
        } catch (Exception e) {
            LOGGER.error("Error parsing geocoding API response: {}", e.getMessage());
            throw new GeocodingException("Failed to parse geocoding API response.");
        }
    }
}

