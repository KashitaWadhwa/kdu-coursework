package org.example.functions;

import org.example.entity.Vehicle;

public class PrintDetails {

    public void printVehicleDetails(Vehicle vehicle, String label) {
        System.out.println(label);
        System.out.println("Speaker Brand: " + vehicle.getSpeaker().getBrand());
        System.out.println("Tyre Brand: " + vehicle.getTyre().getBrand());
        System.out.println("Price: " + vehicle.getPrice());
        System.out.println("---------------");
    }
}
