package com.scaler.productservice.models;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
