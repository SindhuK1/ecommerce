package com.sindhu.ecommerce.repository;

import com.sindhu.ecommerce.models.Category;
import com.sindhu.ecommerce.models.Product;
import com.sindhu.ecommerce.projections.ProductProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{

     Product save(Product product);

    //defenitely has id      may not have id

    Optional<Product> findById(Long id);

    List<Product> getProductByCategoryIn(List<Category> categories);

    Integer countProductByPriceLessThan(Double value);

    List<Product> getProductByName(String name);

    List<Product> getProductByNameAndDescriptionLikeOrderByPrice(String nameText, String DescText);

    List<Product> getProductByCategoryName(String categoryName);
    //select * from products p JOIN category c on p.category_id = c.id and c.name = categoryName
//    List<Product> getAllProducts();

    void deleteProductById(Long id);  //hard delete of row permanently
      // we use save method by marking is_deleted.

    @Query("select p from Product p")
    List<Product> Myreturn();

    @Query("select p from Product p where p.category.name = :categoryName")
    List<Product> allProductsGivenCatNameUsingHQL(@Param("categoryName") String catName);


    @Query(value = "select p.* from product p LEFT JOIN category c ON p.category_id = c.id where c.name =:categoryName", nativeQuery = true)
    List<Product> properSQLQuery(@Param("categoryName") String catName);


    @Query(value = "select p.id, p.name from product p LEFT JOIN category c ON p.category_id = c.id where c.name =:categoryName", nativeQuery = true)
    List<ProductProjections> fetchUsingProjection(@Param("categoryName") String catName);


    // in hql, hibernate requires alias  need name to map the customised table-name response
    @Query(value = "select p.id as id, p.name as name from Product p where p.category.name = :categoryName")
    List<ProductProjections> fetchUsingProjectionHQL(@Param("categoryName") String catName);

//    Product getProductById(String productId);
//    List<Product> getAllByPriceGreaterThan(Double value);
//    List<Product> getAllByNameLike(String text);
//    List<Product> getAllByNameLikeAndPriceLessThanAndCategory(String text, Double priceValue, Category category);
//    List<Product> getAllByNameAndDescription(String text, String description);
}
