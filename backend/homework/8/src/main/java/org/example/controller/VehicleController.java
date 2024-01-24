package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.VehicleRequest;
import org.example.dto.VehicleResponse;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing vehicles in a factory's inventory.
 */
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * Endpoint to add a new vehicle to the factory's inventory.
     *
     * @param request The details of the vehicle to be added.
     * @return ResponseEntity with a success message and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<String> addVehicle(@RequestBody @Valid VehicleRequest request) {
        vehicleService.addVehicle(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehicle added successfully");
    }

    /**
     * Endpoint to get details of a vehicle by its ID.
     *
     * @param id The ID of the vehicle to retrieve.
     * @return ResponseEntity with the details of the vehicle and HTTP status 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> getVehicle(@PathVariable int id) {
        VehicleResponse vehicle = vehicleService.getVehicle(id);
        return ResponseEntity.ok(vehicle);
    }

    /**
     * Endpoint to update the details of a vehicle by its ID.
     *
     * @param id      The ID of the vehicle to update.
     * @param request The updated details of the vehicle.
     * @return ResponseEntity with a success message and HTTP status 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody @Valid VehicleRequest request) {
        vehicleService.updateVehicle(id, request);
        return ResponseEntity.ok("Vehicle updated successfully");
    }

    /**
     * Endpoint to delete a vehicle by its ID.
     *
     * @param id The ID of the vehicle to delete.
     * @return ResponseEntity with a success message and HTTP status 200 (OK).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }

    /**
     * Endpoint to get a list of the most expensive vehicles based on query parameters.
     *
     * @param limit The number of vehicles to retrieve.
     * @return ResponseEntity with a list of the most expensive vehicles and HTTP status 200 (OK).
     */
    @GetMapping("/most-expensive")
    public ResponseEntity<List<VehicleResponse>> getMostExpensiveVehicles(@RequestParam(defaultValue = "5") int limit) {
        List<VehicleResponse> vehicles = vehicleService.getMostExpensiveVehicles(limit);
        return ResponseEntity.ok(vehicles);
    }

    /**
     * Endpoint to get a list of the least expensive vehicles based on query parameters.
     *
     * @param limit The number of vehicles to retrieve.
     * @return ResponseEntity with a list of the least expensive vehicles and HTTP status 200 (OK).
     */
    @GetMapping("/least-expensive")
    public ResponseEntity<List<VehicleResponse>> getLeastExpensiveVehicles(@RequestParam(defaultValue = "5") int limit) {
        List<VehicleResponse> vehicles = vehicleService.getLeastExpensiveVehicles(limit);
        return ResponseEntity.ok(vehicles);
    }
}
