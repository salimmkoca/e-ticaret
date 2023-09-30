package com.example.payment.payment.api;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PaymentDto {
    private int paymentId;
    private int cardNumber;
    private int cardCCV;
    private int expiraitonDate;
    private int userId;
    private int basketId;
}
