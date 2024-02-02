package com.kdu.myapplication.mapper;

import com.kdu.myapplication.dto.CartItemDTO;
import com.kdu.myapplication.dto.ShoppingCartDTO;
import com.kdu.myapplication.entity.CartItem;
import com.kdu.myapplication.entity.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {

    public ShoppingCart mapShoppingCartDTO(ShoppingCartDTO shoppingCartDTO){
        ShoppingCart shoppingCart=new ShoppingCart();
        shoppingCart.setId(shoppingCartDTO.getUser().getId());
        List<CartItem> cartItems = shoppingCartDTO.getCartItems().stream()
                .map(ShoppingCartMapper::mapCartItemDTO)
                .collect(Collectors.toList());

        shoppingCart.setCartItems(cartItems);

        return shoppingCart;
    }

    public static CartItem mapCartItemDTO(CartItemDTO cartItemDTO) {
        CartItem cartItem = new CartItem();
        cartItem.setId(cartItemDTO.getShoppingCart().getId());
        cartItem.setId(cartItemDTO.getProduct().getId());
        cartItem.setQuantity(cartItemDTO.getQuantity());
        return cartItem;
    }

}

