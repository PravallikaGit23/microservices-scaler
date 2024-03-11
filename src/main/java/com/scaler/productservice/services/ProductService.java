package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;

import java.util.List;


public interface ProductService {

    public Product getProduct(Long id);

    Product createProduct(String title, String desc, double price, String imageurl, String category);

    void deleteById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long productId , String title, String desc, Double price, String imageurl, String category);

    List<Category> getAllCategories();

    List<Product> getListOfProductsByCategory(String category);

    Product updateProductWithExisistingDetails(Long productId, String title, String description, double price, String image, String category);
}

