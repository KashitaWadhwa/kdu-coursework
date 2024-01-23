package org.example.functions;

import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class LowestPriceVehicle {

    @Autowired
    private List<Vehicle> vehicles;

    public Vehicle findLowestPriceVehicle() {
        return vehicles.stream()
                .min(Comparator.comparing(Vehicle::getPrice))
                .orElse(null);
    }
}
