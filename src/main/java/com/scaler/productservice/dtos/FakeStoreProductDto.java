package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import lombok.Data;

@Data
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;
   public Product toProduct(){
       Product product = new Product();
       product.setId(id);
       product.setPrice(price);
       product.setImageUrl(image);
       product.setDescription(description);
       product.setTitle(title);

       Category productCategory = new Category();
       productCategory.setTitle(category);

       product.setCategory(productCategory);

       return product;
    }
    public Category toCategory(){
        Category productCategory = new Category();
        productCategory.setTitle(category);
        return  productCategory;
    }
}
