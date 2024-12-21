package com.dronex.category_service.service;

import com.dronex.category_service.shared.dto.CategoryDTO;

import java.util.UUID;

public interface CategoryService {
   

    CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    void deleteCategory(UUID id);
}
