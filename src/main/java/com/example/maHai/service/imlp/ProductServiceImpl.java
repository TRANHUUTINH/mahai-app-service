package com.example.maHai.service.imlp;

import com.example.maHai.dto.ProductDTO;
import com.example.maHai.dto.CreateProductDTO;
import com.example.maHai.mapper.ProductMapper;
import com.example.maHai.model.Category;
import com.example.maHai.model.MenuItem;
import com.example.maHai.repository.CategoryRepository;
import com.example.maHai.repository.MenuItemRepository;
import com.example.maHai.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MenuItemRepository menuItemRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<ProductDTO> getAllProducts() {
        return menuItemRepo.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return menuItemRepo.findById(id)
                .map(ProductMapper::toDTO);
    }

    @Override
    public ProductDTO createProduct(CreateProductDTO dto) {
        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        MenuItem item = new MenuItem();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setCategory(category);

        MenuItem saved = menuItemRepo.save(item);
        return ProductMapper.toDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        MenuItem item = menuItemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setCategory(category);

        return ProductMapper.toDTO(menuItemRepo.save(item));
    }

    @Override
    public void deleteProduct(Long id) {
        menuItemRepo.deleteById(id);
    }

    @Override
    public List<ProductDTO> getProductsByCategoryId(Long categoryId) {
        return menuItemRepo.findByCategoryId(categoryId)
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }
}
