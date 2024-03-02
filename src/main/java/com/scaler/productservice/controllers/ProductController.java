package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int productId){

        return  productService.getProduct(productId);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto product){
       return productService.createProduct(product.getTitle(),
                                    product.getDescription(),
                                    product.getPrice(),
                                    product.getImage(),
                                    product.getCategory());

    }
}
