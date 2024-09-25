package org.example.functions;

import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class LowestPriceVehicle {


    public final List<Vehicle> vehicles;

    @Autowired
    public LowestPriceVehicle(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    public Vehicle findLowestPriceVehicle(List<Vehicle> vehicles) {
        return vehicles.stream()
                .min(Comparator.comparing(Vehicle::getPrice))
                .orElse(null);
    }
}
