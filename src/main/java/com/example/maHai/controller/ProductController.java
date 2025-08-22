package com.example.maHai.controller;

import com.example.maHai.dto.ProductDTO;
import com.example.maHai.dto.CreateProductDTO;
import com.example.maHai.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") // Cho phép gọi từ frontend
public class ProductController {

    @Autowired
    private ProductService productService;

    // Lấy tất cả sản phẩm
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // Lấy sản phẩm theo id
    @GetMapping("/{id}")
    public Optional<ProductDTO> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Tạo mới sản phẩm
    @PostMapping
    public ProductDTO createProduct(@RequestBody CreateProductDTO dto) {
        return productService.createProduct(dto);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return productService.updateProduct(id, dto);
    }

    // Xoá sản phẩm
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Lấy sản phẩm theo category
    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
