package com.example.basket.basketproduct.impl;

import com.example.basket.basket.impl.Basket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketProductId;
    @ManyToOne
    @JoinColumn(name = "basketId")
    private Basket basket;
    private int count;
    private String productName;
    private double price;
    private int productId;
}
