package com.scaler.productservice.repository;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(Category category1);
  
}
