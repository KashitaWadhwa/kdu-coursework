package org.example.inventory;

import org.example.entity.Vehicle;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InventoryStore {

    // Map to store vehicles based on factory information
    private static final Map<String, List<Vehicle>> factoryInventoryMap = new HashMap<>();

    public void addToInventory(Vehicle vehicle, String factoryName) {
        // Check if the factory name is already present in the map
        if (!factoryInventoryMap.containsKey(factoryName)) {
            factoryInventoryMap.put(factoryName, new ArrayList<>());
        }

        // Add the vehicle to the inventory of the specified factory
        factoryInventoryMap.get(factoryName).add(vehicle);
    }

    public List<Vehicle> getInventory(String factoryName) {
        // Retrieve the inventory of the specified factory
        return factoryInventoryMap.getOrDefault(factoryName, new ArrayList<>());
    }
}
