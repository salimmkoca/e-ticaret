package com.example.basket.basketproduct.impl;

import com.example.basket.basketproduct.api.BasketProductDto;
import com.example.basket.basketproduct.api.BasketProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketProductServiceImpl implements BasketProductService {
    private final BasketProductRepository repository;
    private List<BasketProductDto> privateTodto(List<BasketProduct> basketProductList) {
        List<BasketProductDto> dtoList = new ArrayList<>();
        for (BasketProduct basketProduct : basketProductList) {
            dtoList.add(toDto(basketProduct));
        }
        return dtoList;
    }
    private BasketProductDto toDto(BasketProduct basketProduct){
        return BasketProductDto.builder()
                .count(basketProduct.getCount())
                .productName(basketProduct.getProductName())
                .price(basketProduct.getPrice())
                .productId(basketProduct.getProductId())
                .build();
    }
    @Override
    public List<BasketProductDto>toDtoList(List<BasketProduct>basketProducts){
        return privateTodto(basketProducts);
    }

    @Override
    public BasketProductDto find(String id) {
        return toDto(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("BasketProduct not found")));
    }

    @Override
    public void delete(String id) {
        repository.delete(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("BasketProduct not found")));
    }
}
