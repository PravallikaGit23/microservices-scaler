package com.scaler.productservice.services;

import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class fakestoreService implements ProductService{
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getProduct(int productId) {
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
    public void deleteById(int id) {
     restTemplate.delete("https://fakestoreapi.com/products/"+id);
    }
}
