package com.example.payment.payment.impl;
import com.example.payment.payment.api.PaymentDto;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PaymentRequest {
    private int cardNumber;
    private int cardCCV;
    private int expiraitonDate;
    private int userId;
    private int basketId;
    public PaymentDto toDto(){
        return PaymentDto.builder()
                .cardNumber(cardNumber)
                .cardCCV(cardCCV)
                .expiraitonDate(expiraitonDate)
                .userId(userId)
                .basketId(basketId)
                .build();
    }
}
