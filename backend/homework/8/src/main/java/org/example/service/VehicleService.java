package org.example.service;

import org.example.dto.VehicleRequest;
import org.example.dto.VehicleResponse;
import org.example.entity.Vehicle;
import org.example.repository.InventoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class VehicleService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public VehicleService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<VehicleResponse> getAllVehicles() {
        List<Vehicle> vehicles = inventoryRepository.getAllVehicles();
        return mapToResponseList(vehicles);
    }

    public VehicleResponse getVehicle(int vehicleId) {
        Optional<Vehicle> optionalVehicle = inventoryRepository.getVehicleById(vehicleId);
        return optionalVehicle.map(this::mapToResponse).orElse(null);
    }

    public void addVehicle(VehicleRequest vehicleRequest) {
        Vehicle vehicle = mapToEntity(vehicleRequest);
        inventoryRepository.addVehicle(vehicle);
    }

    public void updateVehicle(int vehicleId, VehicleRequest updatedVehicleRequest) {
        Optional<Vehicle> optionalVehicle = inventoryRepository.getVehicleById(vehicleId);
        optionalVehicle.ifPresent(existingVehicle -> {
            Vehicle updatedVehicle = mapToEntity(updatedVehicleRequest);
            inventoryRepository.updateVehicle(vehicleId, updatedVehicle);
        });
    }

    public void deleteVehicle(int vehicleId) {
        inventoryRepository.deleteVehicle(vehicleId);
    }

    private VehicleResponse mapToResponse(Vehicle vehicle) {
        VehicleResponse response = new VehicleResponse();
        BeanUtils.copyProperties(vehicle, response);
        return response;
    }
    public List<VehicleResponse> getMostExpensiveVehicles(int limit) {
        List<Vehicle> vehicles = inventoryRepository.getAllVehicles();

        // Sort vehicles by price in descending order
        List<Vehicle> mostExpensiveVehicles = vehicles.stream()
                .sorted(Comparator.comparingInt(Vehicle::getPrice).reversed())
                .limit(limit)
                .toList();

        return mapToResponseList(mostExpensiveVehicles);
    }

    public List<VehicleResponse> getLeastExpensiveVehicles(int limit) {
        List<Vehicle> vehicles = inventoryRepository.getAllVehicles();

        // Sort vehicles by price in ascending order
        List<Vehicle> leastExpensiveVehicles = vehicles.stream()
                .sorted(Comparator.comparingInt(Vehicle::getPrice))
                .limit(limit)
                .toList();

        return mapToResponseList(leastExpensiveVehicles);
    }

    private List<VehicleResponse> mapToResponseList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(this::mapToResponse)
                .toList();
    }

    private Vehicle mapToEntity(VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleRequest.getName());
        vehicle.setPrice(vehicleRequest.getPrice());
        return vehicle;
    }

}
