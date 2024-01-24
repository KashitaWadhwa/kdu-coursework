package org.example.repository;

import org.example.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Repository
public class InventoryRepository {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    public Optional<Vehicle> getVehicleById(int vehicleId) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId() == vehicleId)
                .findFirst();
    }


    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void updateVehicle(int vehicleId, Vehicle updatedVehicle) {
        // Find the existing vehicle and update its details
        vehicles.stream()
                .filter(vehicle -> vehicle.getId()==(vehicleId))
                .findFirst()
                .ifPresent(existingVehicle -> {
                    existingVehicle.setName(updatedVehicle.getName());
                    existingVehicle.setPrice(updatedVehicle.getPrice());
                    // Update other fields as needed
                });
    }

    public void deleteVehicle(int vehicleId) {
        vehicles.removeIf(vehicle -> vehicle.getId()==(vehicleId));
    }
    public List<Vehicle> getMostExpensiveVehicles(int limit) {
        return vehicles.stream()
                .sorted(Comparator.comparingInt(Vehicle::getPrice).reversed())
                .limit(limit)
                .toList();
    }

    public List<Vehicle> getLeastExpensiveVehicles(int limit) {
        return vehicles.stream()
                .sorted(Comparator.comparingInt(Vehicle::getPrice))
                .limit(limit)
                .toList();
    }
}
