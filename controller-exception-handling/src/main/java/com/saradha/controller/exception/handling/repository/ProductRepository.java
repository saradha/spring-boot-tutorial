package com.saradha.controller.exception.handling.repository;

import com.saradha.controller.exception.handling.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
