package com.example.maHai.service;

import com.example.maHai.dto.ProductDTO;
import com.example.maHai.dto.CategoryDTO;
import com.example.maHai.dto.CreateProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    Optional<ProductDTO> getProductById(Long id);
    ProductDTO createProduct(CreateProductDTO dto);
    ProductDTO updateProduct(Long id, ProductDTO dto);
    void deleteProduct(Long id);

    List<ProductDTO> getProductsByCategoryId(Long categoryId);
    List<CategoryDTO> getAllCategories();

}
