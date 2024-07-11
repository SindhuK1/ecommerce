package com.sindhu.ecommerce.controller;

import com.sindhu.ecommerce.models.Product;
import com.sindhu.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") String productId){
         Product product = productService.getSingleProduct(productId);
         return product;
    }

    @GetMapping("/search")
    //localhost/products?text="hi"
    public List<Product> searchProducts(@RequestParam ("text") String queryText){
        List<Product> products = productService.searchProducts(queryText);
        return products;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return products;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product productReceivedFromRequest){
      Product savedProduct = productService.createProduct(productReceivedFromRequest);
      return savedProduct;
    }

}
