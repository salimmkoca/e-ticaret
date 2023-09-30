package com.example.stock.product.impl;

import com.example.stock.product.api.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return ProductResponse.fromDto(service.create(request.toDto()));
    }
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable (name = "id")String id,@RequestBody ProductRequest request){
        return ProductResponse.fromDto(service.update(id,request.toDto()));
    }
    @GetMapping
    public ProductListResponse getAll(){
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable (name ="id")String id,@RequestBody ProductRequest request){
        service.delete(id,request.toDto());
    }
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable (name = "id")String id,@RequestBody ProductRequest request){
        return ProductResponse.fromDto(service.getById(id,request.toDto()));
    }
}
