package com.example.maHai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.maHai.model.MenuItem;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategoryId(Long categoryId);
}
