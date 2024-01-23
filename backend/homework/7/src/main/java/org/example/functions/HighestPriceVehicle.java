package org.example.functions;

import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class HighestPriceVehicle {

    public final List<Vehicle> vehicles;

    @Autowired
    public HighestPriceVehicle(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    public Vehicle findHighestPriceVehicle(List<Vehicle> vehicles) {
        return vehicles.stream()
                .max(Comparator.comparing(Vehicle::getPrice))
                .orElse(null);
    }
}
