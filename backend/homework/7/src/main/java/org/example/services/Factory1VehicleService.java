package org.example.services;



import org.example.entity.Tyre;
import org.example.entity.Speaker;
import org.example.entity.Vehicle;
import org.example.inventory.InventoryStore;
import org.example.services.factoryspeakerservice.Factory1SpeakerService;
import org.example.services.factorytyreservice.Factory1TyreService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Factory1VehicleService {

    private final Factory1TyreService factorytyreServices;
    private final Factory1SpeakerService factorySpeakerServices;
    private final InventoryStore inventoryStore;

    @Autowired
    public Factory1VehicleService(@Qualifier("factory1TyreService") Factory1TyreService factoryTyreServices,
                                  @Qualifier("factory1SpeakerService") Factory1SpeakerService factorySpeakerServices,
                                  InventoryStore inventoryStore) {
        this.factorytyreServices = factoryTyreServices;
        this.factorySpeakerServices = factorySpeakerServices;
        this.inventoryStore = inventoryStore;
    }

    public List<Vehicle> generateVehicle(int numberOfVehicles) {
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < numberOfVehicles; i++) {
            Tyre tyre = factorytyreServices.generateFactory1Tyre();
            Speaker speaker = factorySpeakerServices.generateFactory1Speaker();
            int price = calculateAdjustedPrice(tyre, speaker);
            Vehicle vehicle = new Vehicle(speaker, tyre, price);

            inventoryStore.addToInventory(vehicle, "Factory1");

            vehicles.add(vehicle);
        }

        return vehicles;
    }


    private int calculateAdjustedPrice(Tyre tyre, Speaker speaker) {
        return (int) (tyre.getPrice() + speaker.getPrice() +  500); // Add an extra charge of 500 for Factory 1
    }
}
