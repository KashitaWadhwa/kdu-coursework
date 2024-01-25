package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.Request;
import org.example.dto.Response;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    /**
     * setter injection
     */
    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    /**
     * adds vehicle to inventory if id is unique
     * @param request post request data
     * @return string indicating method outcome
     */
    @PostMapping("/add/vehicle")
    public String addVehicle(@Valid @RequestBody Request request){
        return vehicleService.addVehicle(request).getResponse();
    }

    /**
     * searches for a vehicle given id and returns if found
     * @param id id of vehicle to be searched
     * @return DTO of vehicle for response
     */
    @GetMapping("/search/vehicle")
    public Response searchVehicle(@RequestParam int id){
        return vehicleService.getVehicle(id);
    }

    /**
     * takes in id and updated details and updates the vehicle
     * @param id id of vehicle
     * @param newVehicle updated vehicle details
     * @return updated vehicle data
     */
    @PutMapping("/update/vehicle/{id}")
    public ResponseEntity<Response> updateVehicle(@PathVariable int id, @Valid @RequestBody Request newVehicle){
        return ResponseEntity.ok(vehicleService.updateVehicle(id,newVehicle));
    }

    /**
     * takes in id and deletes the vehicle
     * @param id id of vehicle
     * @return string indicating method output
     */
    @DeleteMapping("/delete/vehicle/{id}")
    public String deleteVehicle(@PathVariable int id){
        return vehicleService.removeVehicle(id).getResponse();
    }

    /**
     * @return DTO of vehicle
     */
    @GetMapping("/get/mostvehicle")
    public Response getMostExpensiveVehicle() {
        return vehicleService.getMostExpensiveVehicle();
    }

    @GetMapping("/get/leastvehicle")
    public Response getLeastExpensiveVehicle() {
        return vehicleService.getLeastExpensiveVehicle();
    }

}