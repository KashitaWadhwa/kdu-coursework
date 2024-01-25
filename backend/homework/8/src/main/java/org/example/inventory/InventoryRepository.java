package org.example.inventory;

import lombok.Data;
import org.example.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@Repository
public class InventoryRepository {
    List<Vehicle> vehicles=new ArrayList<>();
    public Vehicle getVehicle(int id){
        for(Vehicle v: vehicles){
            if(v.getId() == id){
                return v;
            }
        }
        return null;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void updateVehicle(Vehicle vehicle,Vehicle newVehicle){
        int index = vehicles.indexOf(vehicle);
        vehicles.set(index,newVehicle);
    }

    public void deleteVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    public Vehicle getMostExpensive(){
        return vehicles.stream().max(Comparator.comparing(Vehicle::getPrice)).orElse(null);
    }

    public Vehicle getLeastExpensive(){
        return vehicles.stream().min(Comparator.comparing(Vehicle::getPrice)).orElse(null);
    }
}
