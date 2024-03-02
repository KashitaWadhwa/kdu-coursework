package com.kdu.myapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ProductDTO {
    private String productName;

    private String description;

    private String price;

    private int productQuantity;

    private int restock;
}
