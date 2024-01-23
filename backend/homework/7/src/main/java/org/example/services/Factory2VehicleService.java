package org.example.services;

import org.example.services.factoryspeakerservice.Factory2SpeakerService;
import org.example.services.factorytyreservice.Factory2TyreService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.example.entity.Tyre;
import org.example.entity.Speaker;
import org.example.entity.Vehicle;
import org.example.inventory.InventoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Factory2VehicleService {

    private final Factory2TyreService factorytyreServices;
    private final Factory2SpeakerService factorySpeakerServices;
    private final InventoryStore inventoryStore;

    @Autowired
    public Factory2VehicleService(@Qualifier("factory2TyreService") Factory2TyreService factoryTyreServices,
                                  @Qualifier("factory2SpeakerService") Factory2SpeakerService factorySpeakerServices,
                                  InventoryStore inventoryStore) {
        this.factorytyreServices = factoryTyreServices;
        this.factorySpeakerServices = factorySpeakerServices;
        this.inventoryStore = inventoryStore;
    }

    public List<Vehicle> generateVehicle(int numberOfVehicles) {
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < numberOfVehicles; i++) {
            Tyre tyre = factorytyreServices.generateFactory2Tyre();
            Speaker speaker = factorySpeakerServices.generateFactory2Speaker();
            int price = calculateAdjustedPrice(tyre, speaker);
            Vehicle vehicle = new Vehicle(speaker, tyre, price);

            inventoryStore.addToInventory(vehicle, "Factory1");

            vehicles.add(vehicle);
        }

        return vehicles;
    }

    private int calculateAdjustedPrice(Tyre tyre, Speaker speaker) {
        int adjustedTyrePrice = (int) (tyre.getPrice() * 1.1); // Increase the tire price by 10% for Factory 2
        return (int) (adjustedTyrePrice + speaker.getPrice());
    }
}