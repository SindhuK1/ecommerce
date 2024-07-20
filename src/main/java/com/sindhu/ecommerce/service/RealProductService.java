package com.sindhu.ecommerce.service;

import com.sindhu.ecommerce.dto.FakeStoreRequestDTO;
import com.sindhu.ecommerce.models.Category;
import com.sindhu.ecommerce.models.Product;
import com.sindhu.ecommerce.repository.CategoryRepository;
import com.sindhu.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("RealProductService")
public class RealProductService implements ProductService {


    ProductRepository productRepository;
    CategoryRepository categoryRepository;


    @Autowired
    public RealProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
         this.productRepository = productRepository;
         this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(String productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        //return productRepository.getProductByCategoryName();
       return null;
    }

    @Override
    public List<Product> getProductByCategoryName(String CategoryName) {
        List<Product> response = productRepository.getProductByCategoryName(CategoryName);
        return response;
    }

    @Override
    public List<Product> searchProducts(String searchText) {
        List<Product> productsFromDB = productRepository.getProductByName("");

        //core logic,  filter properties,whether their contains searchText or not
        List<Product> result = new ArrayList<>();
        for (Product product : productsFromDB) {
            if (product.getName().contains(searchText)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product createProduct(Product product) {
        /*
        {
            name: dell
            price: 100000
            desc:  ghldctyuioph
            category: {
              id: null,
              name: laptop
            }
         }
        */
        Optional<Category> optionalCategory = categoryRepository.getCategoryByName(product.getCategory().getName());
       //if category table has no entry for laptop
        if(optionalCategory.isEmpty()) {
            Category category = new Category();
            category.setName(product.getCategory().getName());
            Category savedCategoryObject = categoryRepository.save(category);
            //this has an id =4
            product.setCategory(savedCategoryObject);
            // {
            //            name: dell
            //            price: 100000
            //            desc: ghldctyuioph
            //            category: {
            //              id: 4,
            //              name: laptop
            //            }
            //         }
            //productRepository.save(product);
        }else{
            /*
            bucket =
            category:{
                    id:4,
                    name: laptop
            }
            */
            Category alreadyPresentCategory = optionalCategory.get();
           product.setCategory(alreadyPresentCategory);

        }
        return productRepository.save(product);
    }

    @Override
    public Product createProduct(FakeStoreRequestDTO fakeStoreRequestDTO) {

        return null;
    }
}
