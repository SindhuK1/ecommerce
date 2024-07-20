package com.sindhu.ecommerce.service;

import com.sindhu.ecommerce.dto.FakeStoreRequestDTO;
import com.sindhu.ecommerce.exceptions.DBNotFoundException;
import com.sindhu.ecommerce.exceptions.DBTimeoutException;
import com.sindhu.ecommerce.exceptions.ProductNotFoundException;
import com.sindhu.ecommerce.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
      Product getSingleProduct(String productId) throws ProductNotFoundException, DBNotFoundException, DBTimeoutException;

      List<Product> getAllProducts();

      List<Product> getProductByCategoryName(String CategoryName);

      List<Product> searchProducts(String searchText);

      //to create object in my db
      Product createProduct(Product product);

      //to create object in fakeStore db
      Product createProduct(FakeStoreRequestDTO fakeStoreRequestDTO);



}
