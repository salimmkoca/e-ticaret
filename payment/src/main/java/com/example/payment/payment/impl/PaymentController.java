package com.example.payment.payment.impl;
import com.example.payment.payment.api.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment/")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

}
