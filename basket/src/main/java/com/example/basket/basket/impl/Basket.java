package com.example.basket.basket.impl;

import com.example.basket.basketproduct.impl.BasketProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int basketId;
    private String date;
    private double totalAmount;
    private int status;
    private String userId;
    @OneToMany(mappedBy = "basket",cascade = CascadeType.ALL)
    private List<BasketProduct>productList;
}
