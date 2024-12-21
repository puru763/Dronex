package com.dronex.category_service.data.repository;


import com.dronex.category_service.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository   extends JpaRepository<Category , UUID> {
}
