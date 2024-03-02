package com.kdu.myapplication.dto;

import com.kdu.myapplication.entity.Product;
import com.kdu.myapplication.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDTO {
    private ShoppingCart shoppingCart;

    private Product product;

    private int quantity;

}
