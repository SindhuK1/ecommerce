package com.sindhu.ecommerce.service;

import com.sindhu.ecommerce.dto.*;
import com.sindhu.ecommerce.exceptions.DBNotFoundException;
import com.sindhu.ecommerce.exceptions.DBTimeoutException;
import com.sindhu.ecommerce.exceptions.ProductNotFoundException;
import com.sindhu.ecommerce.models.Category;
import com.sindhu.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("FakeStoreService")
public class FakeStoreProductService implements ProductService{

    //rest template hits the api of the another server
    @Autowired
    RestTemplate restTemplate;


    @Override
    public Product getSingleProduct(String productId) throws ProductNotFoundException, DBNotFoundException, DBTimeoutException {
        FakeStoreResponseDTO response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreResponseDTO.class
        );

        if(response==null){
              throw new ProductNotFoundException("product with id" + productId + "not found");
        }
//        connectToDB();
//        executeSQLQuery();
        // 1. you hit the api, you get back an object;
        // 2. You want to structure the object, into a required format -> FakeStoreResponse zr
        // 3. convert the class structure, to its corresponding object -> response

        Product product = response.toProduct();
        return product;
    }
       private void connectToDB() throws DBNotFoundException {
           throw new DBNotFoundException("db not found");
       }

       private void executeSQLQuery() throws DBTimeoutException{
           throw new DBTimeoutException("db got timedout trying to execute SQL Query");
       }
    @Override
    public List<Product> getAllProducts() {
        FakeStoreResponseDTO[] responseArray = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreResponseDTO[].class
                // we can get only one class either list class or fakeStoreResponse class
        );
        List<Product> productList = new ArrayList<>();
        for(FakeStoreResponseDTO response: responseArray){
            Product product = response.toProduct();
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> getProductByCategoryName(String CategoryName) {
        return List.of();
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {

        return product;
    }

    @Override
    public Product createProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {
        FakeStorePOSTResponseDTO savedProductResponse = restTemplate.postForObject(
                "http://localhost:8080/products",
                fakeStoreRequestDTO,
                FakeStorePOSTResponseDTO.class
        );
        Product product = savedProductResponse.toProduct();
        return product;
    }




//    private Product convertResponseToProduct(FakeStoreResponseDTO responseDTO) {
//
//        Product product = new Product();
//        product.setId(responseDTO.getId());
//        product.setName(responseDTO.getTitle());
//        product.setDescription(responseDTO.getDescription());
//        product.setPrice(responseDTO.getPrice() * 1.0);
//        product.setImageUrl(responseDTO.getImage());
//        Category category = new Category();
//        category.setName(responseDTO.getCategory());
//        product.setCategory(category);
//        return product;
//    }
//
//    private Product convertPOSTResponseToProduct(FakeStorePOSTResponseDTO postResponseDTO){
//        Product product = new Product();
//        product.setId(postResponseDTO.getId());
//        product.setName(postResponseDTO.getTitle());
//        product.setDescription(postResponseDTO.getDescription());
//        product.setPrice(postResponseDTO.getPrice() * 1.0);
//        product.setImageUrl(postResponseDTO.getImage());
//        Category category = new Category();
//        category.setName(postResponseDTO.getCategory());
//        product.setCategory(category);
//
//        return product;
//    }
}
