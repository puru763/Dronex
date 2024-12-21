package com.dronex.category_service.shared.mapper;

import com.dronex.category_service.shared.dto.CategoryDTO;
import com.dronex.category_service.data.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(category.getName());
        return dto;
    }

    public Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }

    public void updateCategory(CategoryDTO dto, Category category) {
        if (dto.getName() != null) {
            category.setName(dto.getName());
        }
    }
}
