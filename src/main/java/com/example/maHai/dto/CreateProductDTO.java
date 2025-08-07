package com.example.maHai.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDTO {
    private String name;
    private double price;
    private Long categoryId;
}