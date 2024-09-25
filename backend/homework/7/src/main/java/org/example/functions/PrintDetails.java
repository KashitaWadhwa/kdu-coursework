package org.example.functions;

import org.example.Logging;
import org.example.entity.Vehicle;

public class PrintDetails {
    private PrintDetails() {
    }

    public static void printVehicleDetails(Vehicle vehicle, String label) {
        Logging.logInfo(label);
        if (vehicle != null) {
            Logging.logInfo("Speaker Brand: " + vehicle.getSpeaker().getBrand());
            Logging.logInfo("Tyre Brand: " + vehicle.getTyre().getBrand());
            Logging.logInfo("Price: " + vehicle.getPrice());
        } else {
            Logging.logInfo("No vehicle details available.");
        }
        Logging.logInfo("---------------");
    }
}
