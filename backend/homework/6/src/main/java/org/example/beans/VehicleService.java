package org.example.beans;

import jakarta.annotation.PostConstruct;
import org.example.entity.*;
import org.example.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class VehicleService {
    private List<Vehicle> vehicles;
    @Autowired
    private TyreService tyreService;
    @Autowired
    private SpeakerService speakerService;
    @PostConstruct
    public void generateVehicleList() {
        vehicles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tyre tyre = tyreService.generateTyre();
            Speaker speaker = speakerService.generateSpeaker();
            Vehicle vehicle = new Vehicle(speaker, tyre);
            vehicles.add(vehicle);
        }
    }

    public Vehicle findMostExpensiveVehicle() {
        if(vehicles==null || vehicles.isEmpty()){
            throw new IllegalArgumentException("vehicle list is empty or null");
        }
        return vehicles.stream()
                .max(Comparator.comparing(Vehicle::calculatePrice))
                .orElseThrow(()-> new RuntimeException("No Vehicles Found!"));
    }


}
