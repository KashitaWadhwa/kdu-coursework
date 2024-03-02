package com.kdu.myapplication.dto;

import com.kdu.myapplication.entity.Address;
import com.kdu.myapplication.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDTO {

    private Address address;

    private ShoppingCart cart;
}
