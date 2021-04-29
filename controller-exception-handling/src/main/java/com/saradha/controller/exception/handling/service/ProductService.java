package com.saradha.controller.exception.handling.service;

import com.saradha.controller.exception.handling.exception.NoProductFoundException;
import com.saradha.controller.exception.handling.model.Product;
import com.saradha.controller.exception.handling.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new NoProductFoundException("No products available");
        }
        return products;

    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
