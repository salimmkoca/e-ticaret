package com.example.stock.product.impl;

import com.example.stock.category.api.CategoryDto;
import com.example.stock.category.api.CategoryService;
import com.example.stock.product.api.ProductDto;
import com.example.stock.product.api.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;

    @Override
    public ProductDto create(ProductDto dto) {
        return toDto(repository.save(toEntity(new Product(),dto)));
    }

    @Override
    public ProductListResponse getAll() {
        return ProductListResponse.builder()
                .productList(repository.findAll()
                        .stream()
                        .map(this::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public ProductDto update(String id, ProductDto dto) {
        return repository.findById(Integer.parseInt(id))
                .map(product -> toEntity(product,dto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
    @Override
    public void delete(String id, ProductDto dto) {
        repository.delete(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Product not found")));
    }

    @Override
    public ProductDto getById(String id, ProductDto dto) {
        return toDto(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Product not found")));
    }

    @Override
    public Product toEntity(Product product, ProductDto productDto) {
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryService.findById(productDto.getCategoryDto().getCategoryId()));
        return product;
    }

    @Override
    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .categoryDto(CategoryDto.builder()
                        .categoryId(product.getCategory().getCategoryId())
                        .categoryName(product.getCategory().getCategoryName())
                        .build())
                .build();
    }
}
