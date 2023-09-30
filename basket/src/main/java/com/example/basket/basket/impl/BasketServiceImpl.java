package com.example.basket.basket.impl;

import com.example.basket.basket.api.BasketDto;
import com.example.basket.basket.api.BasketService;
import com.example.basket.basketproduct.api.BasketProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository repository;
    private final BasketProductService basketProductService;

    @Override
    public BasketDto add(BasketDto dto) {
        return toDto(repository.save(toEntity(new Basket(),dto)));
    }
    @Override
    public BasketDto find(String id, BasketDto dto) {
        return toDto(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Basket not found")));
    }
    @Override
    public void delete(String id, BasketDto dto) {
        repository.delete(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Basket not found")));
    }
    @Override
    public BasketDto findBasketByUser(String id, BasketDto dto) {
        return toDto(repository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Basket not found")));
    }
    private Basket toEntity(Basket basket,BasketDto dto){
        basket.setBasketId(dto.getBasketId());
        basket.setDate(dto.getDate());
        basket.setStatus(dto.getStatus());
        basket.setTotalAmount(dto.getTotalAmount());
        basket.setUserId(dto.getUserId());
        return basket;
    }
    private BasketDto toDto(Basket basket){
        return BasketDto.builder()
                .basketId(basket.getBasketId())
                .date(basket.getDate())
                .status(basket.getStatus())
                .totalAmount(basket.getTotalAmount())
                .userId(basket.getUserId())
                .build();
    }
}
