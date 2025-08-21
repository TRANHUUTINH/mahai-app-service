package com.example.maHai.controller;

import com.example.maHai.dto.CategoryDTO;
import com.example.maHai.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return productService.getAllCategories();
    }
}

