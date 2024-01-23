
package org.example;

import org.example.config.AppConfig;
import org.example.entity.Vehicle;
import org.example.functions.HighestPriceVehicle;
import org.example.functions.LowestPriceVehicle;
import org.example.functions.PrintDetails;
import org.example.services.Factory1VehicleService;
import org.example.services.Factory2VehicleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Factory1VehicleService factory1VehicleService = context.getBean(Factory1VehicleService.class);
        Factory2VehicleService factory2VehicleService = context.getBean(Factory2VehicleService.class);

        List<Vehicle> factory1Vehicles = factory1VehicleService.generateVehicle(3);
        List<Vehicle> factory2Vehicles = factory2VehicleService.generateVehicle(3);

        // Print details of Factory 1 vehicles
        Logging.logInfo("Factory 1 Vehicles:");
        for (Vehicle vehicle : factory1Vehicles) {
            PrintDetails.printVehicleDetails(vehicle, "Vehicle Details:");
        }

        // Print details of Factory 2 vehicles
        Logging.logInfo("Factory 2 Vehicles:");
        for (Vehicle vehicle : factory2Vehicles) {
            PrintDetails.printVehicleDetails(vehicle, "Vehicle Details:");
        }
        HighestPriceVehicle highestPriceVehicle = context.getBean(HighestPriceVehicle.class);
        LowestPriceVehicle lowestPriceVehicle = context.getBean(LowestPriceVehicle.class);

        // Print details of the highest price vehicle for Factory 1
        PrintDetails.printVehicleDetails(highestPriceVehicle.findHighestPriceVehicle(factory1Vehicles), "Factory 1 Highest Price Vehicle Details:");

        // Print details of the highest price vehicle for Factory 2
        PrintDetails.printVehicleDetails(highestPriceVehicle.findHighestPriceVehicle(factory2Vehicles), "Factory 2 Highest Price Vehicle Details:");

        // Print details of the lowest price vehicle for Factory 1
        PrintDetails.printVehicleDetails(lowestPriceVehicle.findLowestPriceVehicle(factory1Vehicles), "Factory 1 Lowest Price Vehicle Details:");

        // Print details of the lowest price vehicle for Factory 2
        PrintDetails.printVehicleDetails(lowestPriceVehicle.findLowestPriceVehicle(factory2Vehicles), "Factory 2 Lowest Price Vehicle Details:");
    }

}