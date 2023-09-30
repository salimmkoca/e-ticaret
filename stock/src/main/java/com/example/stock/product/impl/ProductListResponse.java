package com.example.stock.product.impl;

import com.example.stock.product.api.ProductDto;
import library.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ProductListResponse extends BaseResponse {
    public List<ProductDto>productList;
}
