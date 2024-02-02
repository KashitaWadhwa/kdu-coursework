package com.kdu.myapplication.service;

import com.kdu.myapplication.dao.ProductRepository;
import com.kdu.myapplication.entity.Address;
import com.kdu.myapplication.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private ProductRepository productRepository;

    @Autowired

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        log.info("Adding Product");
        return productRepository.save(product);
    }

    public Product updateProduct(Product updatedProduct) {
        log.info("Product Updated Successfuly");
        return productRepository.save(updatedProduct);
    }

    public void deleteProduct(int productId) {
        log.info("DeletingProduct");
        productRepository.deleteById(productId);
    }

    public void restock(Product product) {
        if (product.needrestock() ) {
            product.setRestock(product.getRestock() + 10);
            productRepository.save(product);
        }
    }
}
