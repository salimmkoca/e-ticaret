package com.example.basket.basket.impl;
import com.example.basket.basket.api.BasketDto;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class BasketRequest {
    private String date;
    private double totalAmount;
    private int status;
    private String userId;
    public BasketDto toDto(){
        return BasketDto.builder()
                .date(date)
                .totalAmount(totalAmount)
                .status(status)
                .userId(userId)
                .build();
    }
}
