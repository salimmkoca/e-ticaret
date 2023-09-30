package com.example.stock.product.api;

import com.example.stock.product.impl.Product;
import com.example.stock.product.impl.ProductListResponse;

public interface ProductService {
    ProductDto create(ProductDto dto);

    ProductListResponse getAll();

    ProductDto update(String id, ProductDto dto);


    ProductDto getById(String id, ProductDto dto);


    Product toEntity(Product product, ProductDto productDto);

    ProductDto toDto(Product product);

    void delete(String id, ProductDto dto);
}
