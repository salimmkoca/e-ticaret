package com.example.stock.product.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product>findByCategory_CategoryId(Integer category);
}
