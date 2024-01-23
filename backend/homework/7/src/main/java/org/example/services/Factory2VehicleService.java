//package org.example.services;
//
//import org.example.entity.Tyre;
//import org.example.entity.Speaker;
//import org.example.entity.Vehicle;
//import org.example.inventory.InventoryStore;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Service;
//
//@Service
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//public class Factory2VehicleService {
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
//    public Vehicle generateVehicle() {
//        Tyre tyre = tyreService.generateTyre();
//        Speaker speaker = speakerService.generateSpeaker();
//
//        // Additional logic specific to Factory 2
//        double adjustedPrice = speaker.getPrice() + tyre.getPrice() + (Math.random() * 10000);
//        adjustedPrice *= 1.1; // Increase by 10%
//
//        Vehicle vehicle = new Vehicle(speaker, tyre, adjustedPrice);
//
//        inventoryStore.addToInventory(vehicle, "Factory2");
//
//        return vehicle;
//    }
//}

package org.example.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.example.entity.Tyre;
import org.example.entity.Speaker;
import org.example.entity.Vehicle;
import org.example.inventory.InventoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Factory2VehicleService {

    private final TyreService tyreService;
    private final SpeakerService speakerService;

    @Autowired
    public Factory2VehicleService(@Qualifier("factory2TyreService") TyreService tyreService,
                                  @Qualifier("factory2SpeakerService") SpeakerService speakerService) {
        this.tyreService = tyreService;
        this.speakerService = speakerService;
    }

    @Autowired
    private InventoryStore inventoryStore;

    private final Random random = new Random();

    public Vehicle generateVehicle() {
        Tyre tyre = tyreService.generateTyre();
        Speaker speaker = SpeakerService.generateSpeaker();
        int price = calculateAdjustedPrice(tyre, speaker);
        Vehicle vehicle = new Vehicle(speaker, tyre, price);

        inventoryStore.addToInventory(vehicle, "Factory2");

        return vehicle;
    }

    private int calculateAdjustedPrice(Tyre tyre, Speaker speaker) {
        int adjustedTyrePrice = (int) (tyre.getPrice() * 1.1); // Increase the tire price by 10% for Factory 2
        return (int) (adjustedTyrePrice + speaker.getPrice());
    }
}
