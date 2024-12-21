package com.dronex.category_service.ui.controller;


import com.dronex.category_service.shared.dto.CategoryDTO;
import com.dronex.category_service.exception.CategoryNotExistsException;
import com.dronex.category_service.exception.InvalidCategoryInputException;
import com.dronex.category_service.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    ///here  also  we   will  sue   and   webclient   to  send  an  request   from  here  to  suer  service
    @PostMapping
    ResponseEntity<CategoryDTO> createSite(@Valid @RequestBody CategoryDTO categoryDTO){
        try{
            CategoryDTO createcategory = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createcategory);
        }catch (InvalidCategoryInputException e ){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //•	GET /categories/user/{userId}:  we    will  do  it  with    the  help  of  na  webclient


    @PutMapping("/{id}")
    ResponseEntity<CategoryDTO> updateSite(@PathVariable UUID id , @RequestBody CategoryDTO categoryDTO ){
        try {
            CategoryDTO updatedCatregory = categoryService.updateCategory(id, categoryDTO);
            return ResponseEntity.ok(updatedCatregory);
        } catch (CategoryNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (InvalidCategoryInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<CategoryDTO>  deleteCategory(@PathVariable UUID  id){
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } catch (CategoryNotExistsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
