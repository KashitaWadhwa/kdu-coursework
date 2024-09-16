package org.example.service;

import org.example.dto.Request;
import org.example.dto.Response;
import org.example.entity.Vehicle;
import org.example.inventory.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VehicleService {
    private String vehicleNotExist = "Vehicle with given id does not exist";
    private final InventoryRepository inventory;
    @Autowired
    public VehicleService(InventoryRepository inventory){
        this.inventory = inventory;
    }

    /**
     * add vehicle to the inventory
     * @param request request DTO
     * @return response DTO
     */
    public Response addVehicle(Request request){
        Vehicle vehicle = inventory.getVehicle(request.getId());
        if(Objects.isNull(vehicle)){
            vehicle = getRequest(request);
        }
        else {
            return getResponse(vehicle,"Vehicle with same id already exists");
        }
        inventory.addVehicle(vehicle);
        return getResponse(vehicle, "Vehicle added successfully");
    }

    /**
     * fetches vehicle from the inventory
     * @param id id of vehicle
     * @return response DTO
     */
    public Response getVehicle(int id){
        Vehicle vehicle = inventory.getVehicle(id);
        if(Objects.isNull(vehicle)){
            return new Response(vehicleNotExist);
        }
        return getResponse(vehicle,"Vehicle fetched");
    }

    /**
     * updates vehicle details in the inventory using id
     * @param id id of vehicle
     * @param newVehicle request DTO for updated details
     * @return response DTO
     */
    public Response updateVehicle(int id,Request newVehicle){
        Vehicle vehicle = inventory.getVehicle(id);
        if(Objects.isNull(vehicle)){
            return new Response(vehicleNotExist);
        }
        else {
            Vehicle nVehicle = getRequest(newVehicle);
            inventory.updateVehicle(vehicle,nVehicle);
            return getResponse(nVehicle,"Vehicle updated successfully");
        }
    }

    /**
     * deletes vehicle from the inventory
     * @param id id of vehicle
     * @return response DTO
     */
    public Response removeVehicle(int id){
        Vehicle vehicle = inventory.getVehicle(id);
        if(Objects.isNull(vehicle)){
            return new Response(vehicleNotExist);
        }
        else {
            inventory.deleteVehicle(vehicle);
            return getResponse(vehicle,"Vehicle deleted successfully");
        }
    }

    /**
     * @return DTO of vehicle
     */
    public Response getMostExpensiveVehicle(){
        Vehicle vehicle;
        vehicle = inventory.getMostExpensive();

        return getResponse(vehicle,"");
    }
    public Response getLeastExpensiveVehicle(){
        Vehicle vehicle;
        vehicle = inventory.getLeastExpensive();

        return getResponse(vehicle,"");
    }


    /**
     * converts request DTO to vehicle
     */
    public Vehicle getRequest(Request request){
        return new Vehicle(request.getId(),request.getName(),request.getPrice());
    }

    /**
     * converts vehicle to response DTO
     */
    public Response getResponse(Vehicle vehicle, String response){
        return new Response(vehicle.getId(),vehicle.getName(),vehicle.getPrice(),response);
    }
}
