package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProduct(Long id);

    Product createProduct(String title, String desc, double price, String imageurl, String category);

    void deleteById(int id);

    List<Product> getAllProducts();

   Product updateProduct(Long productId , String title, String desc, Double price, String imageurl, String category);

    List<String> getAllCategories();

    List<Product> getListOfProductsByCategory(String category);
}

