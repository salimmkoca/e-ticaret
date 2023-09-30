package com.example.basket.basket.impl;

import com.example.basket.basket.api.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("basket/")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;
    @PostMapping
    public BasketResponse addBasket(@RequestBody BasketRequest request)throws EntityNotFoundException{
        return BasketResponse.fromDto(service.add(request.toDto()));
    }
    @GetMapping("/{id}")
    public BasketResponse find(@PathVariable(name = "id")String id,@RequestBody BasketRequest request){
        return BasketResponse.fromDto(service.find(id,request.toDto()));
    }
    @DeleteMapping
    public void delete(@PathVariable(name = "userId")String id,@RequestBody BasketRequest request){
        service.delete(id,request.toDto());
    }
    @GetMapping("/{userId}")
    public BasketResponse findBasketByUser(@PathVariable(name = "userId")String id,@RequestBody BasketRequest request)throws EntityNotFoundException{
        return BasketResponse.fromDto(service.findBasketByUser(id,request.toDto()));
    }
}
