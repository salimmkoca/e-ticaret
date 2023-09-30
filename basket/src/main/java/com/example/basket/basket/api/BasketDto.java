package com.example.basket.basket.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDto {
    private int basketId;
    private String date;
    private double totalAmount;
    private int status;
    private String userId;
}
