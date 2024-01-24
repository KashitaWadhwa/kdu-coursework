package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private int price;

    // Constructors, getters, and setters



}
