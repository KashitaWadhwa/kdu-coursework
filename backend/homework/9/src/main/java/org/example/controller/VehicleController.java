package org.example.controller;

import jakarta.validation.Valid;
import org.example.constants.ErrorMessages;
import org.example.dto.Request;
import org.example.dto.Response;
import org.example.exceptions.NotBlankException;
import org.example.exceptions.PositiveException;
import org.example.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing vehicle-related operations.
 */
@RestController
@RequestMapping("/api")
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
    private final VehicleService vehicleService;

    /**
     * Constructor-based injection.
     *
     * @param vehicleService Instance of VehicleService.
     */
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * Adds a new vehicle to the inventory.
     *
     * @param request Post request data containing vehicle details.
     * @return String indicating the method outcome.
     */
    @PostMapping("/add/vehicle")
    public ResponseEntity<Response> addVehicle(@Valid @RequestBody Request request) {
        try {
            return ResponseEntity.ok(vehicleService.addVehicle(request));
        } catch (NotBlankException | PositiveException ex) {
            // Log the exception if needed
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(ex.getMessage()));
        }
    }

    /**
     * Searches for a vehicle given the ID and returns it if found.
     *
     * @param id ID of the vehicle to be searched.
     * @return DTO of the vehicle for the response.
     */
    @GetMapping("/search/vehicle")
    public Response searchVehicle(@RequestParam int id) {
        return vehicleService.getVehicle(id);
    }

    /**
     * Updates the vehicle details based on ID.
     *
     * @param id         ID of the vehicle.
     * @param newVehicle Updated vehicle details.
     * @return Updated vehicle data as a response.
     */

    @PutMapping("/update/vehicle/{id}")
    public ResponseEntity<Response> updateVehicle(@PathVariable int id, @Valid @RequestBody Request newVehicle) {
        try {
            return ResponseEntity.ok(vehicleService.updateVehicle(id, newVehicle));
        } catch (Exception e) {
            logger.error("Exception occurred while updating vehicle. ID: {}", id, e);
            return ResponseEntity.status(500).body(new Response(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage()));
        }
    }

    /**
     * Deletes the vehicle based on the ID.
     *
     * @param id ID of the vehicle to be deleted.
     * @return String indicating the method output.
     */

    @DeleteMapping("/delete/vehicle/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        try {
            return ResponseEntity.ok(vehicleService.removeVehicle(id).getRes());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage());
        }
    }


    /**
     * Retrieves the DTO of the most expensive vehicle.
     *
     * @return DTO of the most expensive vehicle.
     */
    @GetMapping("/get/mostvehicle")
    public Response getMostExpensiveVehicle() {
        try {
            return vehicleService.getMostExpensiveVehicle();
        } catch (Exception e) {
            logger.error("Exception occurred while fetching the most expensive vehicle.", e);
            return new Response(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage());
        }
    }

    /**
     * Retrieves the DTO of the least expensive vehicle.
     *
     * @return DTO of the least expensive vehicle.
     */
    @GetMapping("/get/leastvehicle")
    public Response getLeastExpensiveVehicle() {
        try {
            return vehicleService.getLeastExpensiveVehicle();
        } catch (Exception e) {
            logger.error("Exception occurred while fetching the least expensive vehicle.", e);
            return new Response(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage());
        }
    }
}
