package com.example.payment.payment.impl;
import com.example.payment.payment.api.PaymentDto;
import library.BaseResponse;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PaymentResponse extends BaseResponse {
    private int paymentId;
    private int cardNumber;
    private int cardCCV;
    private int expiraitonDate;
    private int userId;
    private int basketId;

    public static PaymentResponse fromDto(PaymentDto dto){
        return PaymentResponse.builder()
                .paymentId(dto.getPaymentId())
                .cardNumber(dto.getCardNumber())
                .cardCCV(dto.getCardCCV())
                .expiraitonDate(dto.getExpiraitonDate())
                .userId(dto.getUserId())
                .basketId(dto.getBasketId())
                .build();
    }
}
