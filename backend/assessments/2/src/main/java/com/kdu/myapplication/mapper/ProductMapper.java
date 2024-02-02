package com.kdu.myapplication.mapper;

import com.kdu.myapplication.dto.ProductDTO;
import com.kdu.myapplication.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public Product mapProductDTO(ProductDTO productDTO){
        Product product=new Product();
        product.setProductName(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductQuantity(productDTO.getProductQuantity());
        product.setRestock(productDTO.getRestock());
        return product;
    }
}
