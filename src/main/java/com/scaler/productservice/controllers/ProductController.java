package com.scaler.productservice.controllers;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("selfProductService")
    ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return   productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int productId){

        return  productService.getProduct((long) productId);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto product){
       Product product1 = productService.createProduct(product.getTitle(),
                                    product.getDescription(),
                                    product.getPrice(),
                                    product.getImage(),
                                    product.getCategory());

        return new ResponseEntity<>(product1, HttpStatus.CREATED);

    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId ,
                                 @RequestBody CreateProductRequestDto productRequestDto){
       return productService.updateProduct(productId,productRequestDto.getTitle(),
                productRequestDto.getDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getImage(),
                productRequestDto.getCategory());

    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id){

       productService.deleteById(id);
    }

    @GetMapping("/products/categories")
    public List<String> getAllCategories(){
      return  productService.getAllCategories();
    }

    @GetMapping("/products/category/{categories}")
    public List<Product> getProductsByCategories(@PathVariable("categories") String categoryName){

        return productService.getListOfProductsByCategory(categoryName);

    }
}
