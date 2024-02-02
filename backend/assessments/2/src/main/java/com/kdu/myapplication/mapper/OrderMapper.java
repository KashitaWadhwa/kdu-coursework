package com.kdu.myapplication.mapper;

import com.kdu.myapplication.dto.OrderDTO;
import com.kdu.myapplication.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order mapOrderDTO(OrderDTO orderDTO){
        Order order=new Order();
        order.setId(orderDTO.getAddress().getId());
        order.setId(orderDTO.getCart().getId());
        return order;
    }
}

