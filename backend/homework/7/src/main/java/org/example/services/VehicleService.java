//package org.example.services;
//
//import org.example.entity.Tyre;
//import org.example.entity.Speaker;
//import org.example.entity.Vehicle;
//import org.example.inventory.InventoryStore;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//@Service
//public class VehicleService {
//    private List<Vehicle> vehicles;
//
//    @Autowired
//    private TyreService tyreService;
//
//    @Autowired
//    private SpeakerService speakerService;
//
//    @Autowired
//    private InventoryStore inventoryStore;
//
//    @Autowired
//    private Factory1VehicleService factory1VehicleService;
//
//    @Autowired
//    private Factory2VehicleService factory2VehicleService;
//
//    public void generateVehicleList() {
//        vehicles = new ArrayList<>();
//
//        // Generate vehicles for Factory 1
//        for (int i = 0; i < 3; i++) {
//            Tyre tyre = tyreService.generateTyre();
//            Speaker speaker = SpeakerService.generateSpeaker();
//            int price = calculateAdjustedPrice(tyre, speaker);
//            Vehicle vehicle = new Vehicle(speaker, tyre,price );
//            vehicles.add(vehicle);
//
//            inventoryStore.addToInventory(vehicle, "Factory1");
//        }
//
//        // Generate vehicles for Factory 2
//        for (int i = 0; i < 2; i++) {
//            Tyre tyre = tyreService.generateTyre();
//            Speaker speaker = SpeakerService.generateSpeaker();
//            int price = calculateAdjustedPrice(tyre, speaker);
//            Vehicle vehicle = new Vehicle(speaker, tyre);
//            vehicles.add(vehicle);
//
//            inventoryStore.addToInventory(vehicle, "Factory2");
//        }
//    }
//
//    private int calculateAdjustedPrice(Tyre tyre, Speaker speaker) {
//        int generatePrice = (random.nextInt(10) * 1000);
//        return (int) (tyre.getPrice() + speaker.getPrice() + generatePrice);
//    }
//
//
//}

package org.example.services;

import jakarta.annotation.PostConstruct;
import org.example.entity.Vehicle;
import org.example.inventory.InventoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class VehicleService {

    private List<Vehicle> vehicles;

    @Autowired
    private Factory1VehicleService factory1VehicleService;

    @Autowired
    private Factory2VehicleService factory2VehicleService;

    @Autowired
    private InventoryStore inventoryStore;

    @PostConstruct
    public void generateVehicleList() {
        vehicles = new ArrayList<>();

        // Generate vehicles for Factory 1
        for (int i = 0; i < 3; i++) {
            Vehicle vehicle = factory1VehicleService.generateVehicle();
            vehicles.add(vehicle);
        }

        // Generate vehicles for Factory 2
        for (int i = 0; i < 2; i++) {
            Vehicle vehicle = factory2VehicleService.generateVehicle();
            vehicles.add(vehicle);
        }
    }

}
