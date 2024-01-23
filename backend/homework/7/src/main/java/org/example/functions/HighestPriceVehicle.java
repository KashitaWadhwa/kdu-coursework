package org.example.functions;

import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class HighestPriceVehicle {

    @Autowired
    private List<Vehicle> vehicles;

    public Vehicle findHighestPriceVehicle(List<Vehicle> vehicles) {
        return vehicles.stream()
                .max(Comparator.comparing(Vehicle::getPrice))
                .orElse(null);
    }
}
