package com.example.maHai.service.imlp;

import com.example.maHai.dto.CategoryDTO;
import com.example.maHai.mapper.CategoryMapper;
import com.example.maHai.model.Category;
import com.example.maHai.repository.CategoryRepository;
import com.example.maHai.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
