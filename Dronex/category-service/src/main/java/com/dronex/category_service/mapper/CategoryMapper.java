package com.dronex.category_service.mapper;

import com.dronex.category_service.dto.CategoryDTO;
import com.dronex.category_service.entity.Category;
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

    public void updateSite(CategoryDTO dto, Category category) {
        if (dto.getName() != null) {
            category.setName(dto.getName());
        }
    }
}
