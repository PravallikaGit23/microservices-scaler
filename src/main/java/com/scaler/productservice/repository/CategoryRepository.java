package com.scaler.productservice.repository;

import com.scaler.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByTitle(String category);
}
