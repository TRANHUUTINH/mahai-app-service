package com.example.maHai.mapper;

import com.example.maHai.dto.ProductDTO;
import com.example.maHai.model.MenuItem;

public class ProductMapper {
    public static ProductDTO toDTO(MenuItem item) {
        return new ProductDTO(
            item.getId(),
            item.getName(),
            item.getPrice(),
            item.getCategory() != null ? item.getCategory().getId() : null,
            item.getCategory() != null ? item.getCategory().getName() : null
        );
    }
}
