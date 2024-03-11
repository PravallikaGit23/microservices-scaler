package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class fakestoreService implements ProductService{
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getProduct(Long productId) {
       FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +productId
                , FakeStoreProductDto.class);

        assert fakeStoreProductDto != null;
        return fakeStoreProductDto.toProduct();

    }

    @Override
    public Product createProduct(String title, String desc, double price, String imageurl, String category) {
       FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
       fakeStoreProductDto.setTitle(title);
       fakeStoreProductDto.setDescription(desc);
       fakeStoreProductDto.setPrice(price);
       fakeStoreProductDto.setImage(imageurl);
       fakeStoreProductDto.setCategory(category);

      FakeStoreProductDto fakeStoreProductDto1 = restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto, FakeStoreProductDto.class);
      return fakeStoreProductDto1.toProduct();
    }

    @Override
    public void deleteById(Long id) {
     restTemplate.delete("https://fakestoreapi.com/products/"+id);
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            FakeStoreProductDto[] fakeStoreProductDtos = responseEntity.getBody();

            // Convert FakeStoreProductDtos to Products
            List<Product> productList = Arrays.stream(fakeStoreProductDtos)
                    .map(FakeStoreProductDto::toProduct)
                    .collect(Collectors.toList());

            return productList;
        } else {
            // Handle the case where the request was not successful
            // You can throw an exception, log an error, or return an empty list
            return Collections.emptyList();
        }
    }


    @Override
    public Product updateProduct(Long productId, String title, String desc, Double price, String imageurl, String category) {
            FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
            fakeStoreProductDto.setId(productId);

            if (title != null) {
                fakeStoreProductDto.setTitle(title);
            }
            if (desc != null) {
                fakeStoreProductDto.setDescription(desc);
            }
            if (price != null) {
                fakeStoreProductDto.setPrice(price);
            }
            if (imageurl != null) {
                fakeStoreProductDto.setImage(imageurl);
            }
            if (category != null) {
                fakeStoreProductDto.setCategory(category);
            }


      restTemplate.put("https://fakestoreapi.com/products/"+productId,fakeStoreProductDto);
    return getProduct(productId);

    }

    @Override
    public List<Category> getAllCategories() {
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return Arrays.stream(responseEntity.getBody())
                    .map(categoryName -> {
                        Category category = new Category();
                        category.setTitle(categoryName);
                        return category;
                    })
                    .collect(Collectors.toList());
        } else {
            // Handle the case where the request was not successful
            // You can throw an exception, log an error, or return an empty list
            return Collections.emptyList();
        }
    }


    @Override
    public List<Product> getListOfProductsByCategory(String category) {

        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/"+category,
                FakeStoreProductDto[].class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            FakeStoreProductDto[] fakeStoreProductDtos = responseEntity.getBody();

            // Convert FakeStoreProductDtos to Products
            List<Product> productList = Arrays.stream(fakeStoreProductDtos)
                    .map(FakeStoreProductDto::toProduct)
                    .collect(Collectors.toList());

            return productList;
        } else {
            // Handle the case where the request was not successful
            // You can throw an exception, log an error, or return an empty list
            return Collections.emptyList();
        }
    }

    @Override
    public Product updateProductWithExisistingDetails(Long productId, String title, String description, double price, String image, String category) {
        return null;
    }
}
