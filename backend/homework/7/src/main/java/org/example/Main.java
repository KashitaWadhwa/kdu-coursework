package org.example;

import org.example.config.AppConfig;
import org.example.functions.HighestPriceVehicle;
import org.example.functions.LowestPriceVehicle;
import org.example.functions.PrintDetails;
import org.example.services.VehicleService;

import org.example.services.Factory1VehicleService;
import org.example.services.Factory2VehicleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{

    public static void main(String[] args) {
        // Initialize the Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Access beans and perform any additional logic if needed
        Factory1VehicleService factory1VehicleService = context.getBean(Factory1VehicleService.class);
        Factory2VehicleService factory2VehicleService = context.getBean(Factory2VehicleService.class);

        // Generate vehicles for both factories
        factory1VehicleService.generateVehicle();
        factory2VehicleService.generateVehicle();

        // Call functions to identify highest and lowest prices and print details
        HighestPriceVehicle highestPriceVehicle = context.getBean(HighestPriceVehicle.class);
        LowestPriceVehicle lowestPriceVehicle = context.getBean(LowestPriceVehicle.class);
        PrintDetails printDetails = context.getBean(PrintDetails.class);

// Identify and print details of the highest price vehicle
        printDetails.printVehicleDetails(highestPriceVehicle.findHighestPriceVehicle(), "Highest Price Vehicle Details:");

// Identify and print details of the lowest price vehicle
        printDetails.printVehicleDetails(lowestPriceVehicle.findLowestPriceVehicle(), "Lowest Price Vehicle Details:");


        // Perform any additional startup logic as needed
        System.out.println("Application started. Executing additional logic...");
    }
}
