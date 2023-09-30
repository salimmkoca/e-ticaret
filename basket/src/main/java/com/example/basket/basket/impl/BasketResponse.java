package com.example.basket.basket.impl;

import com.example.basket.basket.api.BasketDto;
import library.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketResponse extends BaseResponse {
    private int basketId;
    private String date;
    private double totalAmount;
    private int status;
    private String userId;

    public static BasketResponse fromDto(BasketDto dto){
        return BasketResponse.builder()
                .basketId(dto.getBasketId())
                .date(dto.getDate())
                .totalAmount(dto.getTotalAmount())
                .status(dto.getStatus())
                .userId(dto.getUserId())
                .build();
    }
}
