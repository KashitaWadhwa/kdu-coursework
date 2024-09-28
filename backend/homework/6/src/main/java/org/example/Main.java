package org.example;

import org.example.beans.VehicleService;
import org.example.config.AppConfig;
import org.example.entity.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            VehicleService vehicleService = context.getBean(VehicleService.class);

            // Generate the list of vehicles
            vehicleService.generateVehicleList();

            // Find and print details of the most expensive vehicle
            Vehicle mostExpensiveVehicle = vehicleService.findMostExpensiveVehicle();
            if (mostExpensiveVehicle != null) {
                Logging.logInfo("Details of the Most Expensive Vehicle:");
                Logging.logInfo("Speaker Brand: " + mostExpensiveVehicle.getSpeaker().getBrand());
                Logging.logInfo("Tyre Brand: " + mostExpensiveVehicle.getTyre().getBrand());
                Logging.logInfo("Price: " + mostExpensiveVehicle.getPrice());
            } else {
                Logging.logInfo("No vehicles found.");
            }
        }
    }
}
