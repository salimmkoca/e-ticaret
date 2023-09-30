package com.example.stock.category.api;

import com.example.stock.category.impl.Category;
import com.example.stock.category.impl.CategoryListResponse;

public interface CategoryService {
    CategoryDto create(CategoryDto dto);

    CategoryDto getById(String id, CategoryDto dto);

    CategoryDto update(String id, CategoryDto dto);

    void delete(String id, CategoryDto dto);

    CategoryListResponse getAll();
    Category findById(int id);
}
