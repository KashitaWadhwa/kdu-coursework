package com.kdu.myapplication.dto;

import com.kdu.myapplication.entity.Product;
import com.kdu.myapplication.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
@Data
public class ShoppingCartDTO {

    private User user;

    private Product product;

    private List<CartItemDTO> cartItems;

}

