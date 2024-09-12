package org.example.service;

import io.micrometer.common.util.StringUtils;
import org.example.constants.ErrorMessages;
import org.example.dto.Request;
import org.example.dto.Response;
import org.example.entity.Vehicle;
import org.example.exceptions.*;
import org.example.inventory.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Service class for managing vehicles.
 */
@Service
public class VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);
    private final InventoryRepository inventory;

    @Autowired
    public VehicleService(InventoryRepository inventory) {
        this.inventory = inventory;
    }

    /**
     * Adds a new vehicle to the inventory.
     *
     * @param request Request DTO containing vehicle details.
     * @return Response DTO indicating the result of the operation.
     * @throws BadRequestException If a vehicle with the same ID already exists.
     */

    public Response addVehicle(Request request) {
        validateRequest(request); // Custom method to validate the request
        logger.info("Adding a new vehicle with ID: {}", request.getId());
        Vehicle vehicle = inventory.getVehicle(request.getId());
        if (Objects.nonNull(vehicle)) {
            logger.error("Vehicle with the same ID already exists. ID: {}", request.getId());
            throw new BadRequestException(ErrorMessages.SAME_ID_EXISTS.getMessage());
        }

        vehicle = getRequest(request);
        inventory.addVehicle(vehicle);

        logger.info("Vehicle added successfully");
        return getResponse(vehicle, "Vehicle added successfully");
    }

    private void validateRequest(Request request) {
        if (StringUtils.isBlank(request.getName())) {
            throw new NotBlankException("Name is required");
        }

        if (request.getPrice() <= 0) {
            throw new PositiveException("Price must be positive");
        }
    }

    /**
     * Fetches a vehicle from the inventory.
     *
     * @param id ID of the vehicle to fetch.
     * @return Response DTO containing the fetched vehicle details.
     * @throws ResourceNotFoundException If the vehicle with the specified ID is not found.
     */
    public Response getVehicle(int id) {
        logger.info("Fetching vehicle with ID: {}", id);

        Vehicle vehicle = inventory.getVehicle(id);
        if (Objects.isNull(vehicle)) {
            logger.error(ErrorMessages.VEHICLE_NOT_FOUND.getMessage());
            throw new ResourceNotFoundException(ErrorMessages.VEHICLE_NOT_FOUND.getMessage());
        }

        logger.info("Vehicle fetched successfully. ID: {}", vehicle.getId());
        return getResponse(vehicle, "Vehicle fetched");
    }

    /**
     * Updates vehicle details in the inventory.
     *
     * @param id         ID of the vehicle to update.
     * @param newVehicle Request DTO containing updated vehicle details.
     * @return Response DTO indicating the result of the operation.
     * @throws ResourceNotFoundException If the vehicle with the specified ID is not found.
     */

    public Response updateVehicle(int id, Request newVehicle) {
        logger.info("Updating vehicle with ID: {}", id);

        // Validation checks for id, name, and price
        validateRequest(newVehicle);

        Vehicle vehicle = inventory.getVehicle(id);
        if (Objects.isNull(vehicle)) {
            logger.error("Vehicle not found with ID: {}", id);
            throw new ResourceNotFoundException(ErrorMessages.VEHICLE_NOT_FOUND.getMessage());
        }

        Vehicle updatedVehicle = getRequest(newVehicle);
        inventory.updateVehicle(vehicle, updatedVehicle);

        logger.info("Vehicle updated successfully. ID: {}", updatedVehicle.getId());
        return getResponse(updatedVehicle, "Vehicle updated successfully");
    }

    /**
     * Removes a vehicle from the inventory.
     *
     * @param id ID of the vehicle to remove.
     * @return Response DTO indicating the result of the operation.
     * @throws ResourceNotFoundException If the vehicle with the specified ID is not found.
     */
    public Response removeVehicle(int id) {
        logger.info("Removing vehicle with ID: {}", id);

        Vehicle vehicle = inventory.getVehicle(id);
        if (Objects.isNull(vehicle)) {
            logger.error("Vehicle not found with ID: {}", id);
            throw new ResourceNotFoundException(ErrorMessages.VEHICLE_NOT_FOUND.getMessage());
        }

        inventory.deleteVehicle(vehicle);

        logger.info("Vehicle deleted successfully. ID: {}", vehicle.getId());
        return getResponse(vehicle, "Vehicle deleted successfully");
    }

    /**
     * Fetches the most expensive vehicle from the inventory.
     *
     * @return Response DTO containing the details of the most expensive vehicle.
     * @throws ResourceNotFoundException If no vehicles are found in the inventory.
     */
    public Response getMostExpensiveVehicle() {
        logger.info("Fetching the most expensive vehicle.");

        Vehicle vehicle = inventory.getMostExpensive();
        if (Objects.isNull(vehicle)) {
            logger.error(ErrorMessages.VEHICLES_NOT_IN_INVENTORY.getMessage());
            throw new ResourceNotFoundException(ErrorMessages.VEHICLES_NOT_IN_INVENTORY.getMessage());
        }

        logger.info("Most expensive vehicle fetched successfully. ID: {}", vehicle.getId());
        return getResponse(vehicle, "");
    }

    /**
     * Fetches the least expensive vehicle from the inventory.
     *
     * @return Response DTO containing the details of the least expensive vehicle.
     * @throws ResourceNotFoundException If no vehicles are found in the inventory.
     */
    public Response getLeastExpensiveVehicle() {
        logger.info("Fetching the least expensive vehicle.");

        Vehicle vehicle = inventory.getLeastExpensive();
        if (Objects.isNull(vehicle)) {
            logger.error("No vehicles found in the inventory.");
            throw new ResourceNotFoundException("No vehicles found in the inventory.");
        }

        logger.info("Least expensive vehicle fetched successfully. ID: {}", vehicle.getId());
        return getResponse(vehicle, "");
    }

    /**
     * Converts a Request DTO to a Vehicle entity.
     *
     * @param request Request DTO to convert.
     * @return Vehicle entity.
     */
    public Vehicle getRequest(Request request) {
        return new Vehicle(request.getId(), request.getName(), request.getPrice());
    }

    /**
     * Creates a Response DTO based on a Vehicle entity and response message.
     *
     * @param vehicle  Vehicle entity.
     * @param response Response message.
     * @return Response DTO.
     */
    public Response getResponse(Vehicle vehicle, String response) {
        return new Response(vehicle.getId(), vehicle.getName(), vehicle.getPrice(), response);
    }


}
