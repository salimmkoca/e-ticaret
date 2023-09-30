package com.example.stock.category.impl;

import com.example.stock.category.api.CategoryDto;
import com.example.stock.category.api.CategoryService;
import com.example.stock.product.api.ProductService;
import com.example.stock.product.impl.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final ProductService productService;

    @Override
    public CategoryDto create(CategoryDto dto) {
        return toDto(repository.save(toEntity(new Category(),dto)));
    }

    @Override
    public CategoryDto getById(String id, CategoryDto dto) {
        return toDto(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Category not found")));
    }

    @Override
    public CategoryDto update(String id, CategoryDto dto) {
        return repository.findById(Integer.parseInt(id))
                .map(category -> toEntity(category,dto))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    @Override
    public void delete(String id, CategoryDto dto) {
        repository.delete(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Category not found")));
    }

    @Override
    public CategoryListResponse getAll() {
        return CategoryListResponse.builder()
                .categoryList(repository.findAll().stream()
                        .map(this::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    private Category toEntity(Category category,CategoryDto dto){
        category.setCategoryName(dto.getCategoryName());
        category.setProductList(Optional.of(dto.getProductList().stream()
                        .map(productDto -> productService.toEntity(new Product(), productDto))
                        .toList())
                .orElse(Collections.emptyList()));
        return category;
    }
    private CategoryDto toDto(Category category){
        return CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .productList(Optional.of(category.getProductList().stream()
                        .map(productService::toDto)
                        .collect(Collectors.toList()))
                        .orElse(Collections.emptyList()))
                .build();
    }

}
