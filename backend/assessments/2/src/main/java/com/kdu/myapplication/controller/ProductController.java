package com.kdu.myapplication.controller;

import com.kdu.myapplication.dao.ProductRepository;
import com.kdu.myapplication.entity.Product;
import com.kdu.myapplication.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    ProductRepository productRepository;
    ProductService productService;


    @Autowired
    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }



    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        productService.restock(addedProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
    }


    @PostMapping("/update")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        log.info("Updating Product: {}", updatedProduct);
        return productService.updateProduct(updatedProduct);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        log.info("Deleting Product with ID: {}", productId);
        productService.deleteProduct(productId);
    }

}
