package com.sindhu.ecommerce;

import com.sindhu.ecommerce.models.Product;
import com.sindhu.ecommerce.projections.ProductProjections;
import com.sindhu.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EcommerceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testAllProductsUsingHQL(){
        List<Product> productList = productRepository.Myreturn();
        for(Product product: productList){
            System.out.println(product.getName());
        }
    }

//    @Test
//    void testAllProductsUsingHQLAndCatName(){
//        List<Product> productList = productRepository.allProductsGivenCatNameUsingHQL("Laptop");
//        for(Product product: productList){
//            System.out.println(product.getName());
//        }
//    }
//
//    @Test
//    void sqlQuery(){
//       List<Product> productList = productRepository.properSQLQuery("Laptop");
//       for(Product product: productList) {
//           System.out.println(product.getName());
//       }
//    }

    @Test
    void sqlfetchUsingProjection(){
       List<ProductProjections> productList = productRepository.fetchUsingProjection("Laptop");
       for(ProductProjections productProjections: productList) {
           System.out.println(productProjections.getId()+ " " + productProjections.getName());
       }
    }

    @Test
    void hqlfetchUsingProjection(){
        List<ProductProjections> productList = productRepository.fetchUsingProjectionHQL("Laptop");
        for(ProductProjections productProjections: productList) {
            System.out.println(productProjections.getId()+ " " + productProjections.getName());
            // System.out.println(productProjections.getIdd()+ " " + productProjections.getNaam());
        }
    }



}
