package com.example.stock.category.impl;

import com.example.stock.category.api.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories/")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public CategoryResponse createCategory (@RequestBody CategoryRequest request){
        return CategoryResponse.fromDto(service.create(request.toDto()));
    }
    @GetMapping("{id}")
    public CategoryResponse getByCategoryId(@PathVariable (name = "id")String id,@RequestBody CategoryRequest request){
        return CategoryResponse.fromDto(service.getById(id,request.toDto()));
    }
    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable (name = "id")String id,@RequestBody CategoryRequest request){
        return CategoryResponse.fromDto(service.update(id,request.toDto()));
    }
    @DeleteMapping
    public void deleteCategory(@PathVariable(name = "id")String id,@RequestBody CategoryRequest request){
       service.delete(id,request.toDto());
    }
    @GetMapping
    public CategoryListResponse getAllCategories(){
        return service.getAll();
    }
}
