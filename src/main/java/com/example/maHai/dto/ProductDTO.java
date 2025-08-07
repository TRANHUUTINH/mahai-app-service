package com.example.maHai.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private Long categoryId;
    private String categoryName;
}
