package com.example.maHai.controller;

import com.example.maHai.dto.CategoryDTO;
import com.example.maHai.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private ProductService productService;

    // Lấy tất cả category
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return productService.getAllCategories();
    }
}
