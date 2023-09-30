package com.example.stock.category.impl;

import com.example.stock.category.api.CategoryDto;
import library.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CategoryListResponse extends BaseResponse {
    private List<CategoryDto>categoryList;
}
