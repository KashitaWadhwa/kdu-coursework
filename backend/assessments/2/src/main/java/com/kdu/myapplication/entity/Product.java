package com.kdu.myapplication.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_table")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int id;

    @Column(name="product_name")
    private String productName;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private String price;

    @Min(value = 2, message = "Product quantity must be at least 2")
    @Column(name="product_quantity")
    private int productQuantity;

    @Column(name = "restock")
    private int restock;

    public boolean needrestock() {
        return productQuantity < restock;
    }
}

