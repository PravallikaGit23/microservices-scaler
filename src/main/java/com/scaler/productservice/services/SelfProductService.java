package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repository.CategoryRepository;
import com.scaler.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product getProduct(Long id) {
       Optional<Product> product =  productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product createProduct(String title, String desc, double price,
                                 String imageurl,
                                 String category) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(desc);
        product.setPrice(price);
        product.setImageUrl(imageurl);

        Category category1 = categoryRepository.findByTitle(category);
        if(category1 == null){
             category1 = new Category();
            category1.setTitle(category);
        }
        product.setCategory(category1);

         product = productRepository.save(product);
        return product;
    }

    @Override
    public void deleteById(Long id) {
      productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long productId, String title, String desc, Double price, String imageurl, String category) {
         Product product = getProduct(productId);
         if(product == null){
             product = new Product();
         }
           product.setId(productId);
           product.setTitle(title);
           product.setDescription(desc);
           product.setPrice(price);
           product.setImageUrl(imageurl);

           Category category1 = categoryRepository.findByTitle(category);
           if (category1 == null) {
               category1 = new Category();
               category1.setTitle(category);
           }
           product.setCategory(category1);

           product = productRepository.save(product);
           return product;
    }

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public List<Product> getListOfProductsByCategory(String category) {
        Category category1 = categoryRepository.findByTitle(category);
        if(category1 != null)
       return productRepository.findByCategory(category1);
        else
            return  new ArrayList<>();
    }

    @Override
    public Product updateProductWithExisistingDetails(Long productId, String title,
                                                      String description, double price, String image,
                                                      String category)
    {
        Product product = getProduct(productId);
        if (product == null) {
            product = new Product();
            product.setId(productId);
        }
            if (title != null)
                product.setTitle(title);
            if (description != null)
                product.setDescription(description);
            if (price != 0)
                product.setPrice(price);
            if (image != null)
                product.setImageUrl(image);

            Category category1 = categoryRepository.findByTitle(category);
            if (category1 == null) {
                category1 = new Category();
                category1.setTitle(category);
            }
            product.setCategory(category1);

            product = productRepository.save(product);
            return product;

    }
}
