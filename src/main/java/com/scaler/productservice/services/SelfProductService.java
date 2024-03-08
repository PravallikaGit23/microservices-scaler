package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repository.CategoryRepository;
import com.scaler.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public Product createProduct(String title, String desc, double price, String imageurl,
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
    public void deleteById(int id) {

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, String title, String desc, Double price, String imageurl, String category) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getListOfProductsByCategory(String category) {
        return null;
    }
}
