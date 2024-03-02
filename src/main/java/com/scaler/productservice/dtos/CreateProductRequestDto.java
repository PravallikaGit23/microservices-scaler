package com.scaler.productservice.dtos;

import lombok.Data;

@Data
public class CreateProductRequestDto {
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

}
