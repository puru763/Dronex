package com.dronex.category_service.service.Impl;


import com.dronex.category_service.dto.CategoryDTO;
import com.dronex.category_service.entity.Category;
import com.dronex.category_service.exception.CategoryNotExistsException;
import com.dronex.category_service.mapper.CategoryMapper;
import com.dronex.category_service.repository.CategoryRepository;
import com.dronex.category_service.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl  implements CategoryService {

    final CategoryMapper categoryMapper;
    final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category =  categoryMapper.toEntity(categoryDTO);
        Category  saveCategory = categoryRepository.save(category);
        return  categoryMapper.toDTO(saveCategory);
    }



    @Override
    public CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (!existingCategory.isPresent()) {
            throw new CategoryNotExistsException("Category  does not exist with this ID: " + id);
        }
        Category category = existingCategory.get();
        categoryMapper.updateCategory(categoryDTO, category);
//        System.out.println("Updated User: " + drone);
        Category updateCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(updateCategory);
    }






    @Override
    public void deleteCategory(UUID id) {

    }

}
