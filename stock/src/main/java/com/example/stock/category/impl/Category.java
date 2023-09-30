package com.example.stock.category.impl;

import com.example.stock.product.impl.Product;
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
public class Category {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> productList;
}
