package org.example.constants;

public enum ErrorMessages {
    VEHICLES_NOT_IN_INVENTORY("No vehicles found in the inventory"),
    VEHICLE_NOT_FOUND("Vehicle with given id does not exist"),
    SAME_ID_EXISTS("Vehicle with the same ID already exists"),
    INTERNAL_SERVER_ERROR("Internal Server Error");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
