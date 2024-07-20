package com.sindhu.ecommerce.controller;

import com.sindhu.ecommerce.dto.FakeStoreRequestDTO;
import com.sindhu.ecommerce.dto.ListProductResponseDTO;
import com.sindhu.ecommerce.dto.ProductResponseDTO;
import com.sindhu.ecommerce.exceptions.DBNotFoundException;
import com.sindhu.ecommerce.exceptions.DBTimeoutException;
import com.sindhu.ecommerce.exceptions.ProductNotFoundException;
import com.sindhu.ecommerce.models.Product;
import com.sindhu.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    //@Qualifier("FakeStoreService")
    @Qualifier("RealProductService")
    ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getSingleProduct(@PathVariable("id") String productId) throws  DBTimeoutException, DBNotFoundException, ProductNotFoundException {

             Product product = productService.getSingleProduct(productId);

             ProductResponseDTO productResponseDTO = new ProductResponseDTO();
             productResponseDTO.setProduct(product);
             productResponseDTO.setResponseMessage("Success");

             ResponseEntity<ProductResponseDTO> responseEntity = new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
             return responseEntity;

    }

    @GetMapping("/search")
    //localhost/search?catName="hi "
    public List<Product> getProductByCategoryName(@RequestParam("catName") String CategoryName){
          List<Product> products = productService.getProductByCategoryName(CategoryName);
          return products;
    }

    @GetMapping("/products")
    public ResponseEntity<ListProductResponseDTO> getAllProducts(){

            List<Product> products = productService.getAllProducts();

            ListProductResponseDTO responseDTO = new ListProductResponseDTO();
            responseDTO.setProductList(products);
            responseDTO.setResponseMessage("Success");
            ResponseEntity<ListProductResponseDTO> responseEntity = new ResponseEntity<>(responseDTO,HttpStatus.OK);
            return responseEntity;

    }

//    @GetMapping("/products")
//    //url /products?categoryName=laptop
//    public List<Product> getProductByCategoryName(@RequestParam("catName") String CategoryName){
//         List<Product> products = productService.getProductByCategoryName(CategoryName);
//         return products;
//    }

    @PostMapping("/products")

    public Product createProduct(@RequestBody Product product){
      Product savedProduct = productService.createProduct(product);
      return savedProduct;
    }


}
