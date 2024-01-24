package org.example.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vehicle {

    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private int price;


}
