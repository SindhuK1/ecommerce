package com.sindhu.ecommerce.service;

import com.sindhu.ecommerce.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
      Product getSingleProduct(String productId);

      List<Product> getAllProducts();

      List<Product> searchProducts(String searchText);

      Product createProduct(Product product);


}
