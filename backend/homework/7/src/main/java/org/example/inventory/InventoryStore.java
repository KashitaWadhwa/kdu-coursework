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

    private static final Map<String, List<Vehicle>> factoryInventoryMap = new HashMap<>();

    public void addToInventory(Vehicle vehicle, String factoryName) {
        factoryInventoryMap.computeIfAbsent(factoryName, key -> new ArrayList<>());


        factoryInventoryMap.get(factoryName).add(vehicle);
    }

    public List<Vehicle> getInventory(String factoryName) {

        return factoryInventoryMap.getOrDefault(factoryName, new ArrayList<>());
    }
}
