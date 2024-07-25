package com.sindhu.ecommerce;

import com.sindhu.ecommerce.models.Category;
import com.sindhu.ecommerce.models.Product;
import com.sindhu.ecommerce.projections.ProductProjections;
import com.sindhu.ecommerce.repository.CategoryRepository;
import com.sindhu.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class EcommerceApplicationTests {


    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public EcommerceApplicationTests(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Test
    void contextLoads() {
    }

//    @Test
//    void testAllProductsUsingHQL(){
//        List<Product> productList = productRepository.Myreturn();
//        for(Product product: productList){
//            System.out.println(product.getName());
//        }
//    }

    @Test
    void testAllProductsUsingHQLAndCatName(){
        List<Product> productList = productRepository.allProductsGivenCatNameUsingHQL("Laptop");
        for(Product product: productList){
            System.out.println(product.getName());
        }
    }

    @Test
    void sqlQuery(){
       List<Product> productList = productRepository.properSQLQuery("Laptop");
       for(Product product: productList) {
           System.out.println(product.getName());
       }
    }

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

    @Test
    void fetchCategoryAndListOfProducts(){
        Optional<Category> categoryOptional = categoryRepository.getCategoryByName("laptop");
        if(categoryOptional.isEmpty()){
            return;
        }
        Category category = categoryOptional.get();
        System.out.println(category.getName());
    }

    //optimised approach
    @Test
    void fetchProduct(){
        Optional<Product> productOptional = productRepository.findById(1L);
        if(productOptional.isEmpty()){
            return;
        }
        Product product = productOptional.get();
        System.out.println(product.getName());
    }


    @Test
    void testNPlusOneProblem(){
        List<Category> categories = categoryRepository.getCategoryByNameContaining("laptop");

        for(Category category : categories){
            System.out.println(category.getName());

            List<Product> product = category.getProducts();
            System.out.println(product.size());
            for(Product p : product){
                System.out.println(p.getName());
            }
        }
    }



}
