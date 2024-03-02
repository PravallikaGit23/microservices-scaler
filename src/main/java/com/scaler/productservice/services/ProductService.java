package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;

public interface ProductService {

    public Product getProduct(int id);

    Product createProduct(String title, String desc, double price, String imageurl, String category);
}
