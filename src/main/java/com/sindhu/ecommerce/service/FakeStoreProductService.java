package com.sindhu.ecommerce.service;

import com.sindhu.ecommerce.dto.FakeStoreResponse;
import com.sindhu.ecommerce.models.Category;
import com.sindhu.ecommerce.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements ProductService{

    //rest template hits the api of the another server
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product getSingleProduct(String productId) {
        FakeStoreResponse response = restTemplate.getForObject(
                "http://localhost:8080/products/" + productId,
                FakeStoreResponse.class
        );
        Product product = new Product();
        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setDescription(response.getDescription());
        product.setPrice(response.getPrice() * 1.0);
        product.setImageUrl(response.getImage());
        Category category = new Category();
        category.setName(response.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponse responseArray = restTemplate.getForObject(
                "http://localhost:8080/products/",
                FakeStoreResponse.class
        );
        List<Product> productList = new ArrayList<>();
        for(FakeStoreResponse response: responseArray){
            Product product = new Product();
            product.setId(response.getId());
            product.setName(response.getTitle());
            product.setDescription(response.getDescription());
            product.setPrice(response.getPrice() * 1.0);
            product.setImageUrl(response.getImage());
            Category category = new Category();
            category.setName(response.getCategory());
            product.setCategory(category);

            productList.add(product);

        }
        return productList;
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
