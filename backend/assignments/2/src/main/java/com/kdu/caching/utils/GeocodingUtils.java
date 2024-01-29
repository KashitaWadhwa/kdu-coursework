package com.kdu.caching.utils;

import lombok.experimental.UtilityClass;

/**
 * Utility class for geocoding-related operations.
 */
@UtilityClass
public class GeocodingUtils {

    // Key prefix for forward geocoding caching
    public static final String FORWARD_GEOCODING_KEY_PREFIX = "#address";

    // Name for forward geocoding caching
    public static final String FORWARD_GEOCODING_NAME = "geocoding";

    // Key prefix for reverse geocoding caching
    public static final String REVERSE_GEOCODING_KEY_PREFIX = "{#latitude,#longitude}";

    // Name for reverse geocoding caching
    public static final String REVERSE_GEOCODING_NAME = "reverse-geocoding";
}
