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
//public class Factory1VehicleService {
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
//        // Additional logic specific to Factory 1
//        double adjustedPrice = speaker.getPrice() + tyre.getPrice() + (Math.random() * 10000);
//        adjustedPrice += 500; // Add an extra charge of 500
//
//        Vehicle vehicle = new Vehicle(speaker, tyre, adjustedPrice);
//
//        inventoryStore.addToInventory(vehicle, "Factory1");
//
//        return vehicle;
//    }
//}

package org.example.services;



import org.example.entity.Tyre;
import org.example.entity.Speaker;
import org.example.entity.Vehicle;
import org.example.inventory.InventoryStore;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Factory1VehicleService {

//    @Autowired
//    private TyreService tyreService;
//
//    @Autowired
//    private SpeakerService speakerService;

    private final TyreService tyreService;
    private final SpeakerService speakerService;

    @Autowired
    public Factory1VehicleService(@Qualifier("factory1TyreService") TyreService tyreService,
                                  @Qualifier("factory1SpeakerService") SpeakerService speakerService) {
        this.tyreService = tyreService;
        this.speakerService = speakerService;
    }

    @Autowired
    private InventoryStore inventoryStore;

    public Vehicle generateVehicle() {
        Tyre tyre = tyreService.generateTyre();
        Speaker speaker = SpeakerService.generateSpeaker();
        int price = calculateAdjustedPrice(tyre, speaker);
        Vehicle vehicle = new Vehicle(speaker, tyre, price);

        inventoryStore.addToInventory(vehicle, "Factory1");

        return vehicle;
    }

    private int calculateAdjustedPrice(Tyre tyre, Speaker speaker) {
        return (int) (tyre.getPrice() + speaker.getPrice() +  500); // Add an extra charge of 500 for Factory 1
    }
}
