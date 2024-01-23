package org.example.functions;

import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class HighestPriceVehicle {

    @Autowired
    private List<Vehicle> vehicles;

    public Vehicle findHighestPriceVehicle() {
        return vehicles.stream()
                .max(Comparator.comparing(Vehicle::getPrice))
                .orElse(null);
    }
}
